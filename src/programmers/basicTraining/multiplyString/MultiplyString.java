package programmers.basicTraining.multiplyString;

// 문자열 곱하기

public class MultiplyString {

    public String solution(String my_string, int k) {
        return my_string.repeat(k);
    }

    public static void main(String[] args) {
        MultiplyString task = new MultiplyString();
        String my_string = "string";
        int k = 3;

        System.out.println(task.solution(my_string, k));
    }

}
