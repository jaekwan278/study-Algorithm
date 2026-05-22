package programmers.skillCheck.level2.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Level2_4_1 {

    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> dupSet = new HashSet<>();
        dupSet.add(words[0]);

        for(int cnt = 1; cnt < words.length; cnt++){
            String before = words[cnt - 1];
            String cur = words[cnt];

            if(before.charAt(before.length()-1) != cur.charAt(0) || dupSet.contains(cur)){
                answer[0] = cnt % n + 1;
                answer[1] = cnt / n + 1;
                break;
            }

            dupSet.add(cur);
        }

        return answer;
    }


    public static void main(String[] args) {
        Level2_4_1 task = new Level2_4_1();

        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

        System.out.println(Arrays.toString(task.solution(n, words)));
    }

}
