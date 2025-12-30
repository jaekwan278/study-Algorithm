package programmers.basicTraining.firstWordN;

// 문자열의 앞의 n글자

public class FirstWordN {

    public String solution(String my_string, int n) {
        return my_string.substring(0, n);
    }

    public static void main(String[] args) {
        FirstWordN task = new FirstWordN();
        String my_string = "ProgrammerS123";
        int n = 11;

        System.out.println(task.solution(my_string, n));
    }
}
