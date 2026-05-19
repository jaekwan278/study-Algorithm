package programmers.practice.fruitVendor;

// 과일 장수

import java.util.Arrays;

public class FruitVendor {

    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length - m; i >= 0; i -= m){
            answer += score[i] * m;
        }

        return answer;
    }

    public static void main(String[] args) {
        FruitVendor task = new FruitVendor();

        int k = 4, m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        System.out.println(task.solution(k, m, score));
    }

}
