package programmers.basicTraining.getMiddleWord;

// 가운데 글자 가져오기

public class GetMiddleWord {

    public String solution(String s) {
        int idx = s.length() / 2;
        return (s.length() % 2 != 0) ? s.charAt(idx) + "" : s.substring(idx-1, idx+1);
    }

    public static void main(String[] args) {
        GetMiddleWord task = new GetMiddleWord();
        String s = "qwer";

        System.out.println(task.solution(s));
    }

}
