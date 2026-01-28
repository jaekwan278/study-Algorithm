package programmers.basicTraining.sculptingArray;

// 배열 조각하기

import java.util.Arrays;

public class SculptingArray {

    public int[] solution(int[] arr, int[] query) {
        int[] answer = Arrays.copyOf(arr, arr.length);

        for(int i = 0; i < query.length; i++){
            if(i % 2 == 0){
                answer = Arrays.copyOfRange(answer, 0, query[i]+1);
            }else{
                answer = Arrays.copyOfRange(answer, query[i], answer.length);
            }
        }

        return answer;
    }

    public int[] solution2(int[] arr, int[] query){
        int head = 0;
        int tail = arr.length - 1;

        for(int i = 0; i < query.length; i++){
            if(i % 2 == 0){
                tail = head + query[i];
            }else{
                head += query[i];
            }
        }

        return Arrays.copyOfRange(arr, head, tail + 1);
    }

    public static void main(String[] args) {
        SculptingArray task = new SculptingArray();
        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};

        System.out.println(Arrays.toString(task.solution2(arr, query)));
    }

}
