package programmers.kakao.failRate;

// 실패율

import java.util.Arrays;

public class FailRate {

    public int[] solution(int N, int[] stages) {
        Integer[] boxed = new Integer[N];
        for(int i = 1; i <= N; i++) boxed[i-1] = i;

        float[] rate = new float[N+1];
        for(int cur : stages){
            if(cur > N) continue;
            rate[cur]++;
        }

        int len = stages.length;
        for(int i = 1; i < rate.length; i++){
            float cnt = rate[i];
            rate[i] /= len;
            len -= (int)cnt;
        }

        Arrays.sort(boxed, (a, b) -> Float.compare(rate[b], rate[a]));

        return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int N, int[] stages) {

        int[] failCount = new int[N + 2];
        for (int s : stages) {
            failCount[s]++;
        }

        int remaining = stages.length;

        double[][] arr = new double[N][2];
        // [][0] = stage, [][1] = failure rate

        for (int i = 1; i <= N; i++) {
            if (remaining == 0) {
                arr[i - 1][0] = i;
                arr[i - 1][1] = 0;
                continue;
            }

            double rate = (double) failCount[i] / remaining;
            arr[i - 1][0] = i;
            arr[i - 1][1] = rate;

            remaining -= failCount[i];
        }

        Arrays.sort(arr, (a, b) -> {
            if (b[1] == a[1]) return Double.compare(a[0], b[0]); // tie 처리
            return Double.compare(b[1], a[1]);
        });

        return Arrays.stream(arr).mapToInt(a -> (int)a[0]).toArray();
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
