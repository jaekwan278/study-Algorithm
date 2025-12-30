package programmers.basicTraining.expandByValue;

// 배열의 원소만큼 추가하기

import utils.Compare;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ExpandByValue {

    public int[] solution(int[] arr) {
        int size = 0;
        for(int num : arr){
            size += num;
        }
        int[] answer = new int[size];

        int length = 0;
        for(int num : arr){
            Arrays.fill(answer, length, (num + length), num);
            length += num;
        }

        return answer;
    }

    public int[] solution2(int[] arr){
        return Arrays.stream(arr)
                .boxed()
                .flatMapToInt(num -> IntStream.generate(() -> num).limit(num))
                .toArray();
    }

    public static void main(String[] args) {
        ExpandByValue task = new ExpandByValue();
        int[] arr = {5, 1, 4};

        System.out.println(Arrays.toString(task.solution(arr)));
        System.out.println(Arrays.toString(task.solution2(arr)));

        Compare.measureTime(()->task.solution(arr), ()->task.solution2(arr));
    }

}
