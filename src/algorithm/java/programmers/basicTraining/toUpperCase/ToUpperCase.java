package programmers.basicTraining.toUpperCase;

// 대문자로 바꾸기

public class ToUpperCase {

    public String solution(String myString) {
        return myString.toUpperCase();
    }

    public static void main(String[] args) {
        ToUpperCase task = new ToUpperCase();
        String myString = "aBcDeFg";

        System.out.println(task.solution(myString));
    }
}
