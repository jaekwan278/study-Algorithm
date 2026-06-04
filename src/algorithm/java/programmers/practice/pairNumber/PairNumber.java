package programmers.practice.pairNumber;

// 숫자 짝궁

import java.util.HashMap;
import java.util.Map;

public class PairNumber {
    public String solution(String X, String Y) {
        int[] xCnt = new int[10];
        int[] yCnt = new int[10];

        for(char ch : X.toCharArray()) xCnt[ch - '0']++;
        for(char ch : Y.toCharArray()) yCnt[ch - '0']++;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < 10; i++){
            map.put(i, Math.min(xCnt[i], yCnt[i]));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            int cnt = map.get(i);
            if(cnt > 0){
                sb.append((i + "").repeat(cnt));
            }
        }

        if(sb.isEmpty()){
            return "-1";
        }else if(sb.charAt(0) == '0' && sb.length() > 1){
            return "0";
        }

        return sb.toString();
    }

    // 개선
    // Map -> 불필요
    // toCharArray -> 문자열 배열 복사
    // "".repeat() -> 반복 + 중간 String 객체 생성
    public String solution2(String X, String Y) {
        int[] xCnt = new int[10];
        int[] yCnt = new int[10];

        for(char ch : X.toCharArray()) xCnt[ch - '0']++;
        for(char ch : Y.toCharArray()) yCnt[ch - '0']++;

        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            int cnt = Math.min(xCnt[i], yCnt[i]);

            while(cnt-- > 0){
                sb.append(i);
            }
        }

        if(sb.isEmpty()){
            return "-1";
        }else if(sb.charAt(0) == '0' && sb.length() > 1){
            return "0";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PairNumber task = new PairNumber();

        String X = "100", Y = "203045";

        System.out.println(task.solution2(X, Y));
    }
}
