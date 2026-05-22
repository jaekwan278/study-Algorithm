package programmers.practice.bestSet;

// 최고의 집합

import java.util.Arrays;

public class BestSet {

    public int[] solution(int n, int s) {
        if(s / n == 0) return new int[]{-1};

        int[] answer = new int[n];
        int div = s / n;
        int remain = s % n;

        Arrays.fill(answer, div);

        for(int i = 0; i < remain; i++){
            answer[answer.length - (1 + i)]++;
        }

        return answer;
    }

    public static void main(String[] args) {
        BestSet task = new BestSet();

        int n = 3, s = 9;

        System.out.println(Arrays.toString(task.solution(n, s)));
    }

}
