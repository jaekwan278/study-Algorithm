package programmers.intro.modeValue;

// 최빈값 구하기

// 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
// 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요.
// 최빈값이 여러 개면 -1을 return 합니다.

// 0 < array의 길이 < 100
// 0 ≤ array의 원소 < 1000

import utils.Compare;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ModeValue {

    public int solution(int[] array) {
        Map<Integer, Integer> modeValue = new HashMap<>();

        for(int n : array){
            if(modeValue.containsKey(n)){
                modeValue.put(n, modeValue.get(n) + 1);
            }else{
                modeValue.put(n, 1);
            }
        }

        int[] sorted = modeValue.values().stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        if(sorted[0] == sorted[1]){
            return -1;
        }

        return modeValue.get(sorted[0]);
    }

    public int solution2(int[] array) {
        int answer = 0;

        Map<Integer, Integer> modeMap = new HashMap<>();
        int maxValue = 0;
        boolean isDup = false;

        for(int num : array){
            int cnt = modeMap.getOrDefault(num, 0) + 1;
            modeMap.put(num, cnt);

            if(cnt > maxValue){
                maxValue = cnt;
                answer = num;
                isDup = false;
            }else if(cnt == maxValue){
                isDup = true;
            }
        }

        return isDup ? -1 : answer;
    }

    public static void main(String[] args) {
        ModeValue task = new ModeValue();
        int[] array = {1, 2, 3, 3, 3, 4};

        System.out.println(task.solution(array));

        Compare.measureTime(() -> task.solution(array), () -> task.solution2(array));
    }

}
