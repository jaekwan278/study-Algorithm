package programmers.practice.knightsWeapon;

// 기사단원의 무기

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KnightsWeapon {

    // 초기
    public int solution(int number, int limit, int power) {

        int[] arr = new int[number];

        for(int i = 0; i < number; i++){

            Set<Integer> divisor = new HashSet<>();
            int cur = i+1;

            for(int j = 1; j <= Math.sqrt(cur); j++){
                if(cur % j == 0){
                    divisor.add(j);
                    divisor.add(cur / j);
                }
            }

            arr[i] = divisor.size() > limit ? power : divisor.size();

        }

        return Arrays.stream(arr).sum();
    }

    // 메모리 개선
    public int solution2(int number, int limit, int power) {
        int answer = 0;

        for(int i = 1; i <= number; i++){
            int cnt = 0;

            for(int j = 1; (j * j) <= i; j++){

                if(i % j == 0){
                    cnt++;
                    if((j * j) != i) cnt++;
                }

            }

            answer += cnt > limit ? power : cnt;
        }

        return answer;
    }

    // 에라토스테네스
    public int solution3(int number, int limit, int power) {
        int answer = 0;

        int[] arr = new int[number+1];

        for(int i = 1; i <= number; i++){
            for(int j = i; j <= number; j += i){
                arr[j]++;
            }
        }

        for(int i = 1; i <= number; i++){
            answer += (arr[i] > limit) ? power : arr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        KnightsWeapon task = new KnightsWeapon();
        int number = 10, limit = 3, power = 2;

        System.out.println(task.solution3(number, limit, power));
    }
}
