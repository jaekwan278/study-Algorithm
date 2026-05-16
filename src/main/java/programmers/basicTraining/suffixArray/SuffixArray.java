package programmers.basicTraining.suffixArray;

// 접미사 배열

import java.util.Arrays;

public class SuffixArray {

    public String[] solution(String my_string) {
        int len = my_string.length();
        String[] answer = new String[len];

        for(int i = 0; i < len; i++){
            String element = my_string.substring(my_string.length()-(i+1));
            answer[i] = element;
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        SuffixArray task = new SuffixArray();
        String my_string = "banana";

        System.out.println(Arrays.toString(task.solution(my_string)));
    }

}
