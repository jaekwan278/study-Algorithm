package programmers.basicTraining.stringOverlay;

// 문자열 겹쳐쓰기

import utils.Compare;

public class StringOverlay {

    public String solution(String my_string, String overwrite_string, int s) {
        char[] answer = my_string.toCharArray();
        char[] src = overwrite_string.toCharArray();

        System.arraycopy(src, 0, answer, s, src.length);
        return new String(answer);
    }

    public String solution2(String my_string, String overwrite_string, int s) {
        char[] my_chars = my_string.toCharArray();
        char[] overwrite_chars = overwrite_string.toCharArray();
        for (int i=0; i<overwrite_chars.length; i++) {
            my_chars[s + i] = overwrite_chars[i];
        }
        return String.valueOf(my_chars);
    }

    public static void main(String[] args) {
        StringOverlay task = new StringOverlay();
        String my_string = "He11oWor1d";
        String overwrite_string = "lloWorl";
        int s = 2;

        System.out.println(task.solution(my_string, overwrite_string, s));

        Compare.measureTime(()->task.solution(my_string, overwrite_string, s), ()->task.solution2(my_string, overwrite_string, s));
    }
}
