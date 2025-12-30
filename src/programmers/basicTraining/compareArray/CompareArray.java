package programmers.basicTraining.compareArray;

// 배열 비교하기

import utils.Compare;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CompareArray {

    public int solution(int[] arr1, int[] arr2) {

        if(arr1.length > arr2.length){
            return 1;
        }else if(arr1.length < arr2.length){
            return -1;
        }else{
            int sum1 = Arrays.stream(arr1).sum();
            int sum2 = Arrays.stream(arr2).sum();

            if(sum1 == sum2){
                return 0;
            }else{
                return (sum1 > sum2) ? 1 : -1;
            }
        }
    }

    public int solution2(int[] arr1, int[] arr2){
        int answer = Integer.compare(arr1.length, arr2.length);

        if(answer == 0){
            answer = Integer.compare(IntStream.of(arr1).sum(), IntStream.of(arr2).sum());
        }

        return answer;
    }

    public static void main(String[] args) {
        CompareArray task = new CompareArray();
        int[] arr1 = {100, 17, 84, 1};
        int[] arr2 = {55, 12, 65, 36};

        System.out.println(task.solution(arr1, arr2));

        Compare.measureTime(()->task.solution(arr1, arr2), ()->task.solution2(arr1, arr2));
    }

}
