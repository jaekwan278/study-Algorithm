package programmers.stackQue.developFunction;

// 기능 개발

import java.util.*;
import java.util.stream.IntStream;

public class DevelopFunction {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] days = IntStream.range(0, speeds.length)
                .map(i -> (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]))
                .toArray();
        int cur = days[0];
        int cnt = 1;

        for(int i = 1; i < days.length; i++){
            if(days[i] <= cur){
                cnt++;
            }else{
                answer.add(cnt);
                cur = days[i];
                cnt = 1;
            }
        }
        answer.add(cnt);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        DevelopFunction task = new DevelopFunction();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(Arrays.toString(task.solution(progresses, speeds)));
    }

}
