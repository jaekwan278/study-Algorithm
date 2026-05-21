package programmers.basicTraining.countBetweenX;

// x 사이의 개수

import java.util.Arrays;

public class CountBetweenX {

    public int[] solution(String myString) {
        String[] btArr = myString.split("x", -1);

        return Arrays.stream(btArr).mapToInt(String::length).toArray();
    }

    public static void main(String[] args) {
        CountBetweenX task = new CountBetweenX();
        String myString = "oxooxoxxox";

        System.out.println(Arrays.toString(task.solution(myString)));
    }
}
