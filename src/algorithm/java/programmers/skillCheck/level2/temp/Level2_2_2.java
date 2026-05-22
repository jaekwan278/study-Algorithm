package programmers.skillCheck.level2.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level2_2_2 {

    public int[][] solution(int n) {
        List<int[]> answer = new ArrayList<>();

        hanoi(answer, n, 1, 2, 3);

        return answer.toArray(new int[answer.size()][2]);
    }

    private void hanoi(List<int[]> answer, int n, int from, int tmp, int to){
        if(n == 1){
            answer.add(new int[]{from, to});
            return;
        }

        hanoi(answer, n - 1, from, to, tmp);

        answer.add(new int[]{from, to});

        hanoi(answer, n - 1, tmp, from, to);
    }

    public static void main(String[] args) {
        Level2_2_2 task = new Level2_2_2();

        int n = 3;

        for(int[] row : task.solution(n)){
            System.out.println(Arrays.toString(row));
        }
    }

}
