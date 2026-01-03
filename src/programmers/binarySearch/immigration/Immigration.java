package programmers.binarySearch.immigration;

// 입국심사

/*

    특정 시간 안에 다 처리할 수 있는가 ?
    특정 시간 :
        min = sortedTimes[0];
        max = sortedTimes[len-1] * n;

 */

import java.util.Arrays;

public class Immigration {

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        return binarySearch(n, times);
    }

    private long binarySearch(int n, int[] sortedTimes){
        long min = sortedTimes[0];
        long max = (long)sortedTimes[sortedTimes.length-1] * n;

        while(min <= max){
            long mid = (min + max) / 2;
            long cnt = 0;

            for(int time : sortedTimes){
                cnt += mid / time;
                if(cnt >= n) break;
            }

            if(cnt >= n){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        return min;
    }


    public static void main(String[] args) {
        Immigration task = new Immigration();

        int n = 6;
        int[] times = {7, 10};

        System.out.println(task.solution(n, times));

    }

}
