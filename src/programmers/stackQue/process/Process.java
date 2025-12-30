package programmers.stackQue.process;

// 프로세스

import utils.Compare;

import java.util.*;

public class Process {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            que.add(new int[]{i, priorities[i]});
        }

        while(!que.isEmpty()){
            boolean hasHigher = false;
            int[] cur = que.poll();

            for(int[] q : que){
                if(cur[1] < q[1]){
                    hasHigher = true;
                    break;
                }
            }

            if(hasHigher){
                que.add(cur);
            }else{
                answer++;
                if(cur[0] == location) return answer;
            }
        }

        return answer;
    }

    public int solution2(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;



        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Process task = new Process();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(task.solution2(priorities, location));

        Compare.measureTime(()-> task.solution(priorities, location), () -> task.solution2(priorities, location));
    }

}
