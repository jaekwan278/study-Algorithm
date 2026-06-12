package benchmark.sumOfContiguousSubSequence;

// 연습문제 > 연속된 부분 수열의 합
// 0. twoPointer()

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(2)
public class SumOfContiguousSubSequenceBenchmark {

    @State(Scope.Thread)
    public static class BenchmarkState{

        @Param({"1000", "10000", "100000"})
        int size;

        @Param({"RANDOM", "WORST"})
        String mode;

        int[] sequence;
        int k;

        @Setup(Level.Trial)
        public void setup(){
            sequence = new int[size];
            k = 0;

            if("RANDOM".equals(mode)){
                Random random = new Random(42);

                sequence[0] = random.nextInt(2) + 1;

                for(int i = 1; i < sequence.length; i++){
                    sequence[i] = sequence[i - 1] + random.nextInt(2);
                }

                int start = random.nextInt(size);
                int end = start + random.nextInt(size - start);

                for(int i = start; i <= end; i++){
                    k += sequence[i];
                }

            }else{
                Arrays.fill(sequence, 1);
                k = size / 2;
            }
        }
    }

    /// try 1 (pass) - tail to head
    @Benchmark
    public int[] tailToHead(BenchmarkState state) {
        int[] answer = new int[2];

        int len = state.sequence.length - 1;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= len; i++){

            int curSum = 0;
            int curLen = len - i;
            for(int j = curLen; j >= 0; j--){

                curSum += state.sequence[j];

                if(curSum == state.k && (curLen - j) <= min){
                    min = curLen - j;

                    answer[0] = j;
                    answer[1] = curLen;
                }

                if(curSum > state.k){
                    break;
                }

                if(curSum < state.k && j == 0){
                    return answer;
                }
            }
        }

        return answer;
    }

    /// try 2 (pass) two pointer
    @Benchmark
    public int[] twoPointer(BenchmarkState state){
        int[] answer = new int[2];

        int sum = 0;
        int left = 0;

        int minLen = Integer.MAX_VALUE;

        for(int right = 0; right < state.sequence.length; right++){

            sum += state.sequence[right];

            while(sum > state.k){
                sum -= state.sequence[left++];
            }

            if(sum == state.k && (right - left) < minLen){
                minLen = right - left;

                answer[0] = left;
                answer[1] = right;
            }
        }

        return answer;
    }
}
