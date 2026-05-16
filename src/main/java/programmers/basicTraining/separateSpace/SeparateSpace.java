package programmers.basicTraining.separateSpace;

// 공백으로 구분하기 2

import utils.Compare;

import java.util.Arrays;

public class SeparateSpace {

    public String[] solution(String my_string) {
        String[] answer = my_string.split(" ");

        return Arrays.stream(answer).filter(str -> !str.isBlank()).toArray(String[]::new);
    }

    public String[] solution2(String my_string){
        return my_string.trim().split("[ ]+");
    }

    public static void main(String[] args) {
        SeparateSpace task = new SeparateSpace();
        String my_string = " i    love  you";

        Compare.measureTime(()-> task.solution(my_string), ()-> task.solution2(my_string));
    }

}
