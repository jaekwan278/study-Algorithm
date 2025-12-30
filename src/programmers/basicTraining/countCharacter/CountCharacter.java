package programmers.basicTraining.countCharacter;

// 문자 개수 세기

import java.util.Arrays;

public class CountCharacter {
    public int[] solution(String my_string) {
        int[] answer = new int[52];

        for(char ch : my_string.toCharArray()){
            if(ch >= 'A' && ch <= 'Z') answer[ch-'A']++;
            else answer[ch-'a'+26]++;
        }

        return answer;
    }

    public static void main(String[] args) {
        CountCharacter task = new CountCharacter();
        String my_string = "Programmers";

        System.out.println(Arrays.toString(task.solution(my_string)));
    }
}
