package programmers.basicTraining.testForNationalCompetition;

// 전국 대회 선발 고사

import utils.Compare;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class TestForNationalCompetition {

    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;

        Map<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < rank.length; i++){
            if(attendance[i]){
                map.put(rank[i], i);
            }
        }

        int cnt = 10000;
        for(int n : map.values()){
            if(cnt == 0){
                break;
            }
            answer += cnt * n;
            cnt /= 100;
        }

        return answer;
    }

    public int solution2(int[] rank, boolean[] attendance){
        return IntStream.range(0, rank.length)
                .filter(i -> attendance[i])
                .boxed()
                .sorted(Comparator.comparing(i -> rank[i]))
                .limit(3)
                .reduce((a, b) -> a * 100 + b)
                .get();
    }

    public int solution3(int[] rank, boolean[] attendance) {

        PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> rank[a] - rank[b]);
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i])
                que.add(i);
        }

        return que.poll() * 10000 + que.poll() * 100 + que.poll();
    }

    public static void main(String[] args) {
        TestForNationalCompetition task = new TestForNationalCompetition();
        int[] rank = {1, 2, 3};
        boolean[] attendance = {true, true, true};

        System.out.println(task.solution2(rank, attendance));

        Compare.measureTime(()->task.solution2(rank, attendance), ()->task.solution3(rank, attendance));
    }

}
