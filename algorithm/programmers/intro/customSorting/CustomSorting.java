package programmers.intro.customSorting;

// 특이한 정렬

// 정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다.
// 이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다.
// 정수가 담긴 배열 numlist와 정수 n이 주어질 때 numlist의 원소를 n으로부터 가까운 순서대로 정렬한 배열을 return하도록 solution 함수를 완성해주세요.

// 1 ≤ n ≤ 10,000
// 1 ≤ numlist의 원소 ≤ 10,000
// 1 ≤ numlist의 길이 ≤ 100
// numlist는 중복된 원소를 갖지 않습니다.

import utils.Compare;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomSorting {

    public int[] solution(int[] numlist, int n) {
        int size = numlist.length;
        int[] answer = new int[size];
        double[] diff = new double[size];
        Map<Double, Integer> rankMap = new HashMap<>();

        for(int i = 0; i < size; i++){
            if(numlist[i] >= n){
                diff[i] = numlist[i] - n;
                rankMap.put(diff[i], numlist[i]);
            }else{
                diff[i] = Math.abs(numlist[i] - n) + 0.1;
                rankMap.put(diff[i], numlist[i]);
            }
        }

        Arrays.sort(diff);

        for(int i = 0; i < size; i++){
            answer[i] = rankMap.get(diff[i]);
        }

        return answer;
    }

    public int[] solution2(int[] numlist, int n){
        return Arrays.stream(numlist)
                .boxed()
                .sorted((a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] solution3ex(int[] numlist, int n){
        return Arrays.stream(numlist)
                .boxed()
                .sorted((a, b) -> (Math.abs(a - b) == Math.abs(b - n) ? a.compareTo(b) : Integer.compare(Math.abs(a - n), Math.abs(b - n))))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        CustomSorting task = new CustomSorting();
        int[] numlist = {10000,20,36,47,40,6,10,7000};
        int n = 30;

        System.out.println(Arrays.toString(task.solution(numlist, n)));

        Compare.measureTime(()-> task.solution(numlist, n), () -> task.solution2(numlist, n))   ;
    }

}
