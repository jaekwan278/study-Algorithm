package programmers.practice.nearestSameChar;

// 가장 가까운 같은 글자

/*



 */

import utils.Compare;

import java.util.*;

public class NearestSameChar {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {

            Integer value = map.put(s.charAt(i), i);

            answer[i] = (value == null) ? -1 : i - value;
        }

        return answer;
    }

    public int[] solution2(String s) {
        int[] answer = new int[s.length()];
        int[] alp = new int[26];

        Arrays.fill(alp, -1);

        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';

            answer[i] = (alp[idx] == -1) ? -1 : i - alp[idx];
            alp[idx] = i;
        }

        return answer;
    }

    public int[] solution3(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            answer[i] = i-map.getOrDefault(ch,i+1);

            map.put(ch,i);
        }

        return answer;
    }

    public static void main(String[] args) {
        NearestSameChar task = new NearestSameChar();
        String s = "banana";

        System.out.println(Arrays.toString(task.solution3(s)));

        Compare.measureTime(()->task.solution3(s), ()->task.solution2(s));
    }
}
