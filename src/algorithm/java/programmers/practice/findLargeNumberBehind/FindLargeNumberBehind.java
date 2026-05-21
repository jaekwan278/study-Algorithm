package programmers.practice.findLargeNumberBehind;

// 뒤에 있는 큰 수 찾기

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FindLargeNumberBehind {

    public int[] solution(int[] numbers) {
        int len = numbers.length;

        int[] answer = new int[len];
        Arrays.fill(answer, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = len-1; i >= 0; i--){

            while(!stack.isEmpty() && stack.peek() <= numbers[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                answer[i] = stack.peek();
            }

            stack.push(numbers[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        FindLargeNumberBehind task = new FindLargeNumberBehind();

        int[] numbers = {9, 1, 5, 3, 6, 2};

        System.out.println(Arrays.toString(task.solution(numbers)));
    }

}
