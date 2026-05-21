package programmers.basicTraining.sumOfIntString;

// 문자열 정수의 합

public class SumOfIntString {

    public int solution(String num_str) {

        return num_str.chars().map(n -> n - '0').sum();
    }

    public static void main(String[] args) {
        SumOfIntString task = new SumOfIntString();
        String num_str = "123";

        System.out.println(task.solution(num_str));
    }
}
