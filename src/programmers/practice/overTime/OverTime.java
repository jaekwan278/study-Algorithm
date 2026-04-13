package programmers.practice.overTime;

// 야근 지수

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class OverTime {

    // Greedy
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int cur : works) pq.offer(cur);

        while (!pq.isEmpty() && n-- > 0) {
            int max = pq.poll();

            if (max == 0) return 0;

            pq.offer(max - 1);
        }

        for (int cur : pq) answer += (long) cur * cur;

        return answer;
    }

    // 이분 탐색
    public long solution2(int n, int[] works){
        long answer = 0;

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int cur : works){
            sum += cur;
            max = Math.max(cur, max);
        }

        if(n > sum) return 0;

        int std = 0;
        while(std < max){
            int mid = (std + max) / 2;

            int reduce = 0;
            for(int cur : works){
                if(cur > mid) reduce += (cur - mid);
            }

            if(reduce > n) std = mid + 1;
            else max = mid;
        }

        int remain = n;
        int[] flat = new int[works.length];
        for(int i = 0; i < works.length; i++){
            if(works[i] > std){
                remain -= works[i] - std;
                flat[i] = std;
            }else{
                flat[i] = works[i];
            }
        }

        Arrays.sort(flat);
        for(int i = flat.length - 1; i >= 0 && remain > 0; i--){
            if(flat[i] > 0){
                flat[i]--;
                remain--;
            }
        }

        for(int cur : flat){
            answer += (long)cur * cur;
        }

        return answer;
    }

    public static void main(String[] args) {
        OverTime task = new OverTime();

        int n = 4;
        int[] works = {10, 1};

        System.out.println(task.solution2(n, works));
    }

}
