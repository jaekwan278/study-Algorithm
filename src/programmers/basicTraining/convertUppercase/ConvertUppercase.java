package programmers.basicTraining.convertUppercase;

// 대문자로 바꾸기

public class ConvertUppercase {

    public String solution(String my_string, String alp) {

        return my_string.replaceAll(alp, alp.toUpperCase());
    }

    public static void main(String[] args) {
        ConvertUppercase task = new ConvertUppercase();
        String my_string = "programmers", alp = "p";

        System.out.println(task.solution(my_string, alp));
    }

}
