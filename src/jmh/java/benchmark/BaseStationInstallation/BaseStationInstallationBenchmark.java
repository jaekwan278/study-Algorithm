package benchmark.BaseStationInstallation;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

// SummerWinter > 기지국 설치
// 0. solution2()

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 5, time = 1)
@Warmup(iterations = 5, time = 1)
@Fork(2)
public class BaseStationInstallationBenchmark {

    private int n, w;
    private int[] stations;

    @Setup
    public void setup(){
        n = 11;
        stations = new int[]{4, 11};
        w = 1;
    }

    // try 2 ( pass )
    @Benchmark
    public int solution2(){
        int answer = 0;

        int range = w * 2 + 1;

        int left = 1;
        for(int cur : stations){

            int right = cur - w;
            int gap = right - left;

            if(gap > 0){
                int cnt = (range + gap - 1) / range;
                answer += cnt;
            }

            left = cur + w + 1;
        }

        if(left <= n){
            int gap = n - left + 1;
            int cnt = (range + gap - 1) / range;
            answer += cnt;
        }

        return answer;
    }

    // other solution 1
    @Benchmark
    public int solution3() {
        int answer = 0;
        int s=0;
        int left =1;
        while(true){
            if(s < stations.length && left >= stations[s] - w){
                left = stations[s]+w+1;
                s++;
            }
            else{
                left=left+w+w+1;
                answer++;
            }
            if(left> n){
                break;
            }
        }

        return answer;
    }
}
