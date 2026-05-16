package programmers.monthlyChallenge.pickTwoAndAdd;

// 두개 뽑아서 더하기

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PickTwoAndAdd {

    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        PickTwoAndAdd task = new PickTwoAndAdd();
        int[] numbers = {5,7,2,0};

        System.out.println(Arrays.toString(task.solution(numbers)));
    }
}
