package programmers.stackQue.hateSameNumber;

// 같은 숫자는 싫어

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class HateSameNumber {

    public int[] solution(int []arr) {
        Deque<Integer> que = new ArrayDeque<>();

        for(int i : arr){
            if(!que.isEmpty() && i == que.peekLast()){
                continue;
            }else{
                que.addLast(i);
            }
        }

        return que.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        HateSameNumber task = new HateSameNumber();
        int[] arr = {1,1,3,3,0,1,1};

        System.out.println(Arrays.toString(task.solution(arr)));
    }

}
