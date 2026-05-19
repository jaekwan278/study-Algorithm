package programmers.practice.hallOfFame;

// 명예의 전당

import java.util.Arrays;
import java.util.PriorityQueue;

public class HallOfFame {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < score.length; i++){
            pq.add(score[i]);

            if(pq.size() > k){
                pq.poll();
            }

            Integer cur = pq.peek();
            answer[i] = (cur == null) ? 0 : cur;
        }

        return answer;
    }

    public static void main(String[] args) {
        HallOfFame task = new HallOfFame();
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        System.out.println(Arrays.toString(task.solution(k, score)));
    }

}
