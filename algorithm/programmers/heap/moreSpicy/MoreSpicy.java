package programmers.heap.moreSpicy;

// 더 맵게

import java.util.*;

public class MoreSpicy {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pQue = new PriorityQueue<>();
        for(int sc : scoville) pQue.add(sc);

        while(pQue.peek() < K){;
            if(pQue.size() < 2) return -1;
            pQue.add(pQue.poll() + (pQue.poll() * 2));
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        MoreSpicy task = new MoreSpicy();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(task.solution(scoville, K));
    }

}
