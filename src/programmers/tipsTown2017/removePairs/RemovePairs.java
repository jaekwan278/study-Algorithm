package programmers.tipsTown2017.removePairs;

// 짝지어 제거하기

import java.util.ArrayDeque;
import java.util.Deque;

public class RemovePairs {

    public int solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        for(char c : s.toCharArray()){

            if(!dq.isEmpty() && dq.peek().equals(c)){
                dq.pop();
            }else{
                dq.push(c);
            }

        }

        return dq.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        RemovePairs task = new RemovePairs();
        String s = "baabaa";

        System.out.println(task.solution(s));
    }

}
