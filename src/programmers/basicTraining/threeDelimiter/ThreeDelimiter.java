package programmers.basicTraining.threeDelimiter;

// 세개의 구분자

import java.util.Arrays;

public class ThreeDelimiter {

    public String[] solution(String myStr) {
        String[] answer = Arrays.stream(myStr.split("[abc]")).filter(str -> !str.isEmpty()).toArray(String[]::new);

        return (answer.length < 1) ? new String[]{"EMPTY"} : answer;
    }

    public static void main(String[] args) {
        ThreeDelimiter task = new ThreeDelimiter();
        String myStr = "baconlettucetomato";

        System.out.println(Arrays.toString(task.solution(myStr)));
    }
}
