package programmers.basicTraining.divisibleArray;

// 나누어 떨어지는 숫자 배열

import utils.Compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisibleArray {

    public int[] solution(int[] arr, int divisor) {
        if(divisor == 1){
            Arrays.sort(arr);
            return arr;
        }

        List<Integer> answer = new ArrayList<>();
        for(int num : arr){
            if(num % divisor == 0){
                answer.add(num);
            }
        }

        if(answer.isEmpty()){
            return new int[]{-1};
        }

        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public int[] solution2(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
        if(answer.length == 0) answer = new int[] {-1};
        java.util.Arrays.sort(answer);
        return answer;
    }

    public int[] solution3(int[] array, int divisor) {
        //ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.

        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i]%divisor==0){

                index++;
            }
        }
        int[] ret = new int[index];
        int count = 0;
        for(int i=0;i<array.length;i++){

            if(array[i]%divisor==0){
                ret[count++] = array[i];

            }

        }

        return ret;
    }

    public static void main(String[] args) {
        DivisibleArray task = new DivisibleArray();
        int[] arr = {5, 9, 7, 10};
        int divisor = 1;

//        System.out.println(Arrays.toString(task.solution(arr, divisor)));

        Compare.measureTime(()->task.solution(arr, divisor), ()->task.solution2(arr, divisor));
    }

}
