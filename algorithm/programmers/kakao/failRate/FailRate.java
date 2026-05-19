package programmers.kakao.failRate;

// 실패율

import java.util.Arrays;

public class FailRate {

    public int[] solution(int N, int[] stages) {
        int[] failCnt = new int[N + 2];
        for(int cur : stages){
            failCnt[cur]++;
        }

        int length = stages.length;
        double[][] rateArr = new double[N][2];

        for(int i = 1; i <= N; i++){
            if(length == 0){
                rateArr[i-1][0] = i;
                rateArr[i-1][1] = 0;
                continue;
            }

            double rate = (double)failCnt[i] / length;
            rateArr[i-1][0] = i;
            rateArr[i-1][1] = rate;

            length -= failCnt[i];
        }

        Arrays.sort(rateArr, (a, b) -> {
            if(b[1] == a[1]) return Double.compare(a[0], b[0]);
            return Double.compare(b[1], a[1]);
        });

        return Arrays.stream(rateArr).mapToInt(a -> (int)a[0]).toArray();
    }

    public static void main(String[] args) {
        FailRate task = new FailRate();

        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

//        int N = 4;
//        int[] stages = {4,4,4,4,4};

        System.out.println(Arrays.toString(task.solution(N, stages)));
    }

}
