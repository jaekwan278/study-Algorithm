package programmers.basicTraining.prefixChecker;

// 접두사인지 확인하기

public class PrefixChecker {

    public int solution(String my_string, String is_prefix) {
        return my_string.startsWith(is_prefix) ? 1 : 0;
    }

    public static void main(String[] args) {
        PrefixChecker task = new PrefixChecker();
        String my_string = "banana";
        String is_prefix = "ban";

        System.out.println(task.solution(my_string, is_prefix));
    }
}
