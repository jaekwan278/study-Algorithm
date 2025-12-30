package programmers.heap.diskController;

// 디스크 컨트롤러

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {

    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> waitQue = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );

        int idx = 0;
        int time = 0;
        while(idx < n || !waitQue.isEmpty()){

            while(idx < n && jobs[idx][0] <= time){
                waitQue.add(jobs[idx]);
                idx++;
            }

            if(!waitQue.isEmpty()){
                int[] cur = waitQue.poll();
                time += cur[1];
                answer += time - cur[0];
            }else{
                time = jobs[idx][0];
            }
        }

        return answer / n;
    }

    public static void main(String[] args) {
        DiskController task = new DiskController();
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};

        System.out.println(task.solution(jobs));
    }

}
