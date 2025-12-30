package programmers.montlyChallenge;

// 이진 변환 반복하기

import java.util.Arrays;

public class RepeatBinaryConvert {

    public int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")){
            StringBuilder sb = new StringBuilder();

            for(char ch : s.toCharArray()){
                if(ch != '0'){
                    sb.append(ch);
                }else{
                    answer[1]++;
                }
            }

            s = Integer.toBinaryString(sb.length());

            answer[0]++;
        }

        return answer;
    }

    public static void main(String[] args) {
        RepeatBinaryConvert task = new RepeatBinaryConvert();

        System.out.println(Arrays.toString(task.solution("110010101001")));
    }

}
