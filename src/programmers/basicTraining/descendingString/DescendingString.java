package programmers.basicTraining.descendingString;

// 문자열 내림차순으로 배치하기

import java.util.Arrays;

public class DescendingString {

    public String solution(String s) {
        char[] answer = s.toCharArray();
        Arrays.sort(answer);

        for(int i = 0; i < answer.length/2; i++){
            char tmp = answer[i];
            answer[i] = answer[answer.length-1-i];
            answer[answer.length-1-i] = tmp;
        }

        return String.valueOf(answer);
    }

    public String solution2(String s){
        char[] answer = s.toCharArray();
        Arrays.sort(answer);

        return new StringBuilder(String.valueOf(answer)).reverse().toString();
    }

    public static void main(String[] args) {
        DescendingString task = new DescendingString();
        String s = "Zbcdefg";

        System.out.println(task.solution(s));
    }

}
