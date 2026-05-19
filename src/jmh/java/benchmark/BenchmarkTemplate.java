package benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

// 스레드 독립 객체 생성
@State(Scope.Thread)
// 평균 시간 측정
@BenchmarkMode(Mode.AverageTime)
// 나노 초 단위 측정
@OutputTimeUnit(TimeUnit.NANOSECONDS)

// 각 benchmark 메서드를 1초동안 반복실행 5번 동안 예열
@Warmup(iterations = 5, time = 1)
// 실제 측정 단계
@Measurement(iterations = 5, time = 1)
// jvm 2번 생성해서 테스트
@Fork(2)
public class BenchmarkTemplate {

    private int value;

    @Setup
    public void setup(){
        value = 10;
    }

    @Benchmark
    public int testMethod(){
        return value * 2;
    }
}
