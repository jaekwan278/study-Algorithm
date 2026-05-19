package runner;

import benchmark.BenchmarkTemplate;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class RunnerTemplate {

    public static void main(String[] args) throws Exception {

        Options options = new OptionsBuilder()
                .include(BenchmarkTemplate.class.getSimpleName())
                .forks(2)   // Benchmark class @Fork 어노테이션 보다 우선순위 높음 override
                .build();

        new Runner(options).run();
    }

}
