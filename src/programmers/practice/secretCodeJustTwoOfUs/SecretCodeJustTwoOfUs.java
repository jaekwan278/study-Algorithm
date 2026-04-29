package programmers.practice.secretCodeJustTwoOfUs;

// 둘만의 암호

import utils.Compare;

import java.util.ArrayList;
import java.util.List;

public class SecretCodeJustTwoOfUs {

    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        int[] alp = new int[26];
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(skip.contains(ch + "")) continue;
            alp[ch - 'a'] = 1;
        }

        for(char ch : s.toCharArray()){

            int idx = 1;
            int cur = ch - 'a';
            for(int cnt = 0; cnt < index;){
                cnt += alp[(cur + idx) % 26];
                idx++;
            }

            char code = (char)('a' + ((cur + idx - 1) % 26));
            sb.append(code);
        }

        return sb.toString();
    }

    // gpt
    public String solution2(String s, String skip, int index) {
        // 1. skip 체크
        boolean[] isSkip = new boolean[26];
        for (char c : skip.toCharArray()) {
            isSkip[c - 'a'] = true;
        }

        // 2. 사용 가능한 문자 리스트 만들기
        List<Character> list = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (!isSkip[c - 'a']) {
                list.add(c);
            }
        }

        // 3. 각 문자의 index 매핑
        int[] pos = new int[26];
        for (int i = 0; i < list.size(); i++) {
            pos[list.get(i) - 'a'] = i;
        }

        // 4. 변환
        StringBuilder sb = new StringBuilder();
        int size = list.size();

        for (char c : s.toCharArray()) {
            int curIdx = pos[c - 'a'];
            int nextIdx = (curIdx + index) % size;
            sb.append(list.get(nextIdx));
        }

        return sb.toString();
    }

    public String solution3(String s, String skip, int index){
        StringBuilder answer = new StringBuilder();

        boolean[] isSkip = new boolean[26];
        for(char c : skip.toCharArray()){
            isSkip[c - 'a'] = true;
        }



        return answer.toString();
    }

    public static void main(String[] args) {
        SecretCodeJustTwoOfUs task = new SecretCodeJustTwoOfUs();

        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        System.out.println(task.solution(s, skip, index));

        Compare.measureTime(()->task.solution(s, skip, index), ()->task.solution2(s, skip, index));
    }

}
