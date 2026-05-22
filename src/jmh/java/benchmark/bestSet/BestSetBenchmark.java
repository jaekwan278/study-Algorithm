package benchmark.bestSet;

// benchmark : 연습문제 > 최고의 집합

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(2)
public class BestSetBenchmark { // result : A = 6, B = 400

    private int n, s;

    @Setup
    public void setup(){
        n = 5;
        s = 183;
    }

    @Benchmark
    public int[] testA(){
        if(s / n == 0) return new int[]{-1};

        int[] answer = new int[n];
        int div = s / n;
        int remain = s % n;

        Arrays.fill(answer, div);

        for(int i = 0; i < remain; i++){
            answer[answer.length - (1 + i)]++;
        }

        return answer;
    }

    @Benchmark
    public int[] testB(){

        int localS = s;

        int[] answer = null;
        if(n>localS) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[n];
            int i = 0;
            while(localS>0) {
                answer[(i%n)]++;
                i++;
                localS--;
            }

        }
        Arrays.sort(answer);
        return answer;
    }
}
