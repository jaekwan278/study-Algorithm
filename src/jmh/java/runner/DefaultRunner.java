package runner;

import benchmark.bestSet.BestSetBenchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class DefaultRunner {

    public static void main(String[] args) throws Exception {

        Options options = new OptionsBuilder()
                .include(BestSetBenchmark.class.getSimpleName())
                .forks(2)   // Benchmark class @Fork 어노테이션 보다 우선순위 높음 override
                .build();

        new Runner(options).run();
    }

}
