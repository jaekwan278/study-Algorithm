package programmers.intro.AtoB;

import java.util.Arrays;

public class AtoB {
    public int solution(String before, String after) {
        int answer = 0;

        char[] beforeArr = before.toCharArray();
        char[] afterArr = after.toCharArray();

        Arrays.sort(beforeArr);
        Arrays.sort(afterArr);

        answer = Arrays.equals(beforeArr, afterArr) ? 1 : 0;
        return answer;
    }

    public static void main(String[] args) {
        AtoB test = new AtoB();
        System.out.println(test.solution("ollah", "hello"));
    }
}
