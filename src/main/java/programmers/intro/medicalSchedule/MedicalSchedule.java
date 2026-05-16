package programmers.intro.medicalSchedule;

// 외과의사 머쓱이는 응급실에 온 환자의 응급도를 기준으로 진료 순서를 정하려고 합
// 니다. 정수 배열 emergency가 매개변수로 주어질 때 응급도가 높은 순서대로 진료
// 순서를 정한 배열을 return하도록 solution 함수를 완성해주세요.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MedicalSchedule {

    public int[] solution(int[] emergency) {
        int length = emergency.length;
        int[] answer = new int[length];

        int[] sorted = emergency.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for(int i = length - 1; i >= 0; i--){
            rankMap.put(sorted[i], rank++);
        }

        for(int i = 0; i < length; i++){
            answer[i] = rankMap.get(emergency[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        MedicalSchedule task = new MedicalSchedule();
        for (int n : task.solution(new int[]{30, 10, 23, 6, 100})){
            System.out.print(n);
        }
    }

}
