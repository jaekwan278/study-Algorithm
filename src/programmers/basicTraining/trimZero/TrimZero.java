package programmers.basicTraining.trimZero;

// 0 떼기

public class TrimZero {

    public String solution(String n_str) {

        return n_str.replaceFirst("^0+", "");
    }

    public static void main(String[] args) {
        TrimZero task = new TrimZero();
        String n_str = "854020";

        System.out.println(task.solution(n_str));
    }
}
