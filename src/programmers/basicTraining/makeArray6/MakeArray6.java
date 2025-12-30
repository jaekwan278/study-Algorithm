package programmers.basicTraining.makeArray6;

// 배열 만들기 6

import utils.Compare;

import java.util.*;

public class MakeArray6 {

    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{arr[0]};

        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for(int i = 1; i < arr.length; i++){
            if(answer.isEmpty()){
                answer.add(arr[i]);
            }else{
                if(answer.get(answer.size()-1) == arr[i]){
                    answer.remove(answer.size()-1);
                }else{
                    answer.add(arr[i]);
                }
            }
        }

        return answer.isEmpty() ? new int[]{-1} : answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int[] arr){
        if(arr.length == 1) return new int[]{arr[0]};

        Deque<Integer> answer = new ArrayDeque<>();

        for(int n : arr){
            if(answer.isEmpty()){
                answer.add(n);
            }else{
                if(answer.peekLast() == n) answer.pollLast();
                else answer.add(n);
            }
        }

        return answer.isEmpty() ? new int[]{-1} : answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        MakeArray6 task = new MakeArray6();
        int[] arr = {0, 1, 1, 0};

        System.out.println(Arrays.toString(task.solution(arr)));

        Compare.measureTime(()->task.solution(arr), ()->task.solution2(arr));
    }

}
