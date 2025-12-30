package programmers.basicTraining.randomKPick;

// 무작위로 K개의 수 뽑기

import utils.Compare;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomKPick {

    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);

        Set<Integer> set = new LinkedHashSet<>();

        for(int n : arr){
            set.add(n);
            if(set.size() >= k){
                break;
            }
        }

        int idx = 0;
        for(int n : set){
            answer[idx++] = n;
            if(idx >= k) break;
        }

        return answer;
    }

    public int[] solution2(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);

        int[] tmp = new LinkedHashSet<>(Arrays.stream(arr).boxed().collect(Collectors.toList()))
                .stream().limit(k).mapToInt(Integer::intValue).toArray();

        System.arraycopy(tmp, 0, answer, 0, Math.min(tmp.length, k));

        return answer;
    }

    public static void main(String[] args) {
        RandomKPick task = new RandomKPick();
        int[] arr = {0, 1, 1, 1, 1};
        int k = 4;

        System.out.println(Arrays.toString(task.solution2(arr, k)));

        Compare.measureTime(()->task.solution(arr, k), ()->task.solution2(arr, k));
    }

}
