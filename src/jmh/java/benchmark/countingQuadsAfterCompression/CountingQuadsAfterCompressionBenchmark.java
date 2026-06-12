package benchmark.countingQuadsAfterCompression;

import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

// 월간 코드 챌린지 시즌1 > 쿼드압축 후 개수 세기
// 0. testRecursion()

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(2)
public class CountingQuadsAfterCompressionBenchmark {

    @State(Scope.Thread)
    public static class BenchmarkState{
        @Param({"256", "512", "1024"})
        int size;

        int[][] arr;

        @Setup(Level.Trial)
        public void setup(){
            Random random = new Random(42);

            arr = new int[size][size];

            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    arr[i][j] = random.nextBoolean() ? 1 : 0;
                }
            }
        }
    }

    @State(Scope.Thread)
    public static class WorkingState{
        int[][] arr;

        @Setup(Level.Invocation)
        public void setup(BenchmarkState benchmarkState){
            arr = deepCopy(benchmarkState.arr);
        }
    }

    @Benchmark
    public int[] testLoop(WorkingState state){
        int[][] arr = state.arr;
        int[] answer = new int[2];

        int len = arr.length;
        int range = arr.length / 2;

        while(range >= 1){

            for(int i = 0; i < len; i += range){
                for(int j = 0; j < len; j += range){
                    int target = arr[i][j];

                    if(target == 2){
                        fill(i, j, (range / 2), arr);
                        continue;
                    }

                    if(isSame(i, (i + range), j, (j + range), target, arr)){
                        fill(i, j, (range / 2), arr);
                        answer[target]++;
                    }
                }
            }

            range /= 2;
        }

        return answer;
    }

    @Benchmark
    public int[] testRecursion(WorkingState state){
        int[][] arr = state.arr;
        int[] answer = new int[2];

        int range = arr.length;

        recursion(arr, 0, 0, range, answer);

        return answer;
    }

    /// loop
    private static void fill(int row, int col, int offset, int[][] arr){
        arr[row][col] = 2;
        arr[row][col + offset] = 2;
        arr[row + offset][col] = 2;
        arr[row + offset][col + offset] = 2;
    }
    private static boolean isSame(int rowBegin, int rowEnd, int colBegin, int colEnd, int target, int[][] arr){
        for(int i = rowBegin; i < rowEnd; i++){
            for(int j = colBegin; j < colEnd; j++){

                if(arr[i][j] != target) return false;

            }
        }

        return true;
    }

    /// recursion
    private static void recursion(int[][] arr, int row, int col, int range, int[] result){

        int target = arr[row][col];

        for(int i = row; i < (row + range); i++){
            for(int j = col; j < (col + range); j++){

                if(arr[i][j] != target){
                    int half = range / 2;

                    recursion(arr, row, col, half, result);
                    recursion(arr, (row + half), col, half, result);
                    recursion(arr, row, (col + half), half, result);
                    recursion(arr, (row + half), (col + half), half, result);

                    return;
                }
            }
        }

        result[target]++;
    }

    ///  deep copy
    private static int[][] deepCopy(int[][] arr){
        int[][] copy = new int[arr.length][];

        for(int i = 0; i < arr.length; i++){
            copy[i] = arr[i].clone();
        }

        return copy;
    }
}
