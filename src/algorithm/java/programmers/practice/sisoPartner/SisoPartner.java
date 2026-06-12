package programmers.practice.sisoPartner;

// 시소 짝꿍

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SisoPartner {

    ///  try 2
    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);

        Map<Integer, Integer> partnerMap = new HashMap<>();

        for(int cur : weights){

            answer += partnerMap.getOrDefault(cur, 0);

            if(cur % 2 == 0){
                answer += partnerMap.getOrDefault((cur / 2), 0);
            }
            if((cur * 2) % 3 == 0){
                answer += partnerMap.getOrDefault((cur * 2 / 3), 0);
            }
            if((cur * 3) % 4 == 0){
                answer += partnerMap.getOrDefault((cur * 3 / 4), 0);
            }

            partnerMap.put(cur, partnerMap.getOrDefault(cur, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        SisoPartner task = new SisoPartner();

        int[] weights = {100,180,360,100,270};

        System.out.println(task.solution(weights));
    }
}
