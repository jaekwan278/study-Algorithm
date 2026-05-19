package programmers.basicTraining.removeAD;

import java.util.Arrays;

public class RemoveAD {
    public String[] solution(String[] strArr) {
        return Arrays.stream(strArr).filter(str -> !str.contains("ad")).toArray(String[]::new);
    }

    public static void main(String[] args) {
        RemoveAD task = new RemoveAD();
        String[] strArr = {"and","notad","abcd"};

        System.out.println(Arrays.toString(task.solution(strArr)));
    }
}
