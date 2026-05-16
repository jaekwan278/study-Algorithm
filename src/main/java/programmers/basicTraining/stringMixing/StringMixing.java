package programmers.basicTraining.stringMixing;

// 문자열 섞기

public class StringMixing {

    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str1.length(); i++){
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        StringMixing task = new StringMixing();
        String str1 = "aaaaa", str2 = "bbbbb";

        System.out.println(task.solution(str1, str2));
    }

}
