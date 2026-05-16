package programmers.basicTraining.substringChecker;

// 부분 문자열인지 확인하기

public class SubstringChecker {

    public int solution(String my_string, String target) {
        return (my_string.contains(target)) ? 1 : 0;
    }

    public static void main(String[] args) {
        SubstringChecker task = new SubstringChecker();
        String my_string = "banana";
        String target = "ab";

        System.out.println(task.solution(my_string, target));
    }

}
