package programmers.basicTraining.twoRange;

// 2의 영역

import utils.Compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoRange {

    public int[] solution(int[] arr) {
        int start = -1, end = -1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2 && start == -1){
                start = i;
                end = i;
            }else if(arr[i] == 2 && start != -1){
                end = i;
            }
        }

        return (start == -1) ? new int[]{-1} : Arrays.copyOfRange(arr, start, end + 1);
    }

    public int[] solution2(int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2) answer.add(i);
        }

        if(answer.isEmpty()) return new int[]{-1};
        else return Arrays.copyOfRange(arr, answer.get(0), answer.get(answer.size()-1)+1);
    }

    public static void main(String[] args) {
        TwoRange task = new TwoRange();
        int[] arr = {1, 2, 1, 2, 1, 10, 2, 1};

//        System.out.println(Arrays.toString(task.solution2(arr)));

        Compare.measureTime(()->task.solution(arr), ()->task.solution2(arr));
    }
}
