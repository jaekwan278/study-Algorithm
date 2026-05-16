package programmers.practice.memoryScore;

// 추억 점수

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MemoryScore {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> map = new HashMap<>(name.length * 2);
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photo.length; i++){
            int sum = 0;

            for(String str : photo[i]){
                sum += map.getOrDefault(str, 0);
            }

            answer[i] = sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        MemoryScore task = new MemoryScore();

        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        System.out.println(Arrays.toString(task.solution(name, yearning, photo)));
    }

}
