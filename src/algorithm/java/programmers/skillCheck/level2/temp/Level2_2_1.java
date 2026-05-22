package programmers.skillCheck.level2.temp;

import java.util.Arrays;

public class Level2_2_1 {

    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];

        int idx = 0;
        for(long block = begin; block <= end; block++){

            if(block == 1){
                answer[idx++] = 0;
                continue;
            }

            int result = 1;
            for(long i = 2; i * i <= block; i++){

                if(block % i == 0){
                    long pair = block / i;

                    if(pair <= 10_000_000){
                        result = (int) pair;
                        break;
                    }

                    if(i <= 10_000_000){
                        result = (int) i;
                    }
                }
            }

            answer[idx++] = result;
        }

        return answer;
    }

    public static void main(String[] args) {
        Level2_2_1 task = new Level2_2_1();

        long begin = 1, end = 10;

        System.out.println(Arrays.toString(task.solution(begin, end)));
    }
}

