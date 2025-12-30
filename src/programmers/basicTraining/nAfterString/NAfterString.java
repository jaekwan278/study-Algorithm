package programmers.basicTraining.nAfterString;

// 문자열 뒤의 n글자

public class NAfterString {

    public String solution(String my_string, int n) {
        return my_string.substring(my_string.length() - n);
    }

    public static void main(String[] args) {
        NAfterString task = new NAfterString();
        String my_string = "ProgrammerS123";
        int n = 11;

        System.out.println(task.solution(my_string, n));
    }

}
