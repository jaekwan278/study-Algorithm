package programmers.basicTraining.makeArray4;

// 배열 만들기 4

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MakeArray4 {

    public int[] solution(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();

        int cnt = 0;
        while(cnt < arr.length){
            if(deque.isEmpty()){
                deque.addLast(arr[cnt]);
                cnt++;
            }else{
                if(deque.peekLast() < arr[cnt]){
                    deque.addLast(arr[cnt]);
                    cnt++;
                }
                else deque.pollLast();
            }
        }

        return deque.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        MakeArray4 task = new MakeArray4();
        int[] arr = {1, 4, 2, 5, 3};

        System.out.println(Arrays.toString(task.solution(arr)));
    }

}
