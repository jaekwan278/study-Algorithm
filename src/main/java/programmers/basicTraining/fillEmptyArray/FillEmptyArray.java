package programmers.basicTraining.fillEmptyArray;

// 빈 배열에 추가, 삭제하기

import utils.Compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FillEmptyArray {

    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            int length = 0;
            if(flag[i]){
                length = arr[i] * 2;
                for(int j = 0; j < length; j++){
                    list.add(arr[i]);
                }
            }else{
                length = arr[i];
                for(int j = 0; j < length; j++){
                    list.remove(list.size() - 1);
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int[] arr, boolean[] flag){
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            if(flag[i]){
                for(int j = 0; j < (arr[i] * 2); j++) stack.push(arr[i]);
            }else{
                for(int j = 0; j < arr[i]; j++) stack.pop();
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        FillEmptyArray task = new FillEmptyArray();
        int[] arr = {3, 2, 4, 1, 3};
        boolean[] flag = {true, false, true, false, false};

        System.out.println(Arrays.toString(task.solution(arr, flag)));

        Compare.measureTime(()->task.solution(arr, flag), ()->task.solution2(arr, flag));
    }

}
