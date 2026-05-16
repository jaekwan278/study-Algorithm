package programmers.hash.poketmon;

// 폰켓몬

import utils.Compare;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Poketmon {

    public int solution(int[] nums) {
        int answer = nums.length / 2;

        HashSet<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }

        return Math.min(answer, set.size());
    }

    public int solution2(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        answer -> Integer.min(answer.size(), nums.length / 2)));
    }

    public static void main(String[] args) {
        Poketmon task = new Poketmon();
        int[] nums = {3,3,3,2,2,2};

        System.out.println(task.solution(nums));

        Compare.measureTime(()-> task.solution(nums), ()-> task.solution2(nums));
    }

}
