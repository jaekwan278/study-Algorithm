package programmers.summerWinter2018.englishWordChain;

// 영어 끝말잇기

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EnglishWordChain {

    public int[] solution(int n, String[] words) {

        Set<String> dup = new HashSet<>();
        dup.add(words[0]);

        char lastAlp = words[0].charAt(words[0].length()-1);

        for(int i = 1; i < words.length; i++){

            int idx = (i % n) + 1;
            int cnt = (i / n) + 1;

            String cur = words[i];

            if(!dup.add(cur) || cur.charAt(0) != lastAlp){
                return new int[]{idx, cnt};
            }

            lastAlp = cur.charAt(cur.length()-1);
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        EnglishWordChain task = new EnglishWordChain();
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        System.out.println(Arrays.toString(task.solution(n, words)));
    }

}
