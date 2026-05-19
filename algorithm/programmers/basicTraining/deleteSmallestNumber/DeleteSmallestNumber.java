package programmers.basicTraining.deleteSmallestNumber;

// 가장 작은 수 제거하기

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteSmallestNumber {

    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};

        int[] answer = new int[arr.length-1];
        int idx = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < arr[idx]) idx = i;
        }

        System.arraycopy(arr, 0, answer, 0, idx);
        System.arraycopy(arr, idx + 1, answer, idx, answer.length-idx);

        return answer;
    }

    public int[] solution2(int[] arr){
        if(arr.length == 1) return new int[]{-1};

        List<Integer> answer = new ArrayList<>();
        int idx = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < arr[idx]) idx = i;
            answer.add(arr[i]);
        }

        answer.remove(idx);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        DeleteSmallestNumber task = new DeleteSmallestNumber();
        int[] arr = {4,3,2,1};

        System.out.println(Arrays.toString(task.solution2(arr)));
    }

}
