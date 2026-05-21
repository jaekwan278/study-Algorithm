package programmers.binarySearch.steppingStones;

// 징검다리

/*

    거리가 짧은 바위 우선 제거 ?
        sort -> 0, [2, 11, 14, 17, 21], 25
        distance[] -> [2, 9, 3, 3, 4, 4]

 */

import java.util.Arrays;

public class SteppingStones {

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        if(n >= rocks.length) return distance;

        Arrays.sort(rocks);

        int[] tmp = Arrays.copyOfRange(rocks, 0, rocks.length+1);
        tmp[tmp.length-1] = distance;

        return binarySearch(n, tmp);
    }

    private int binarySearch(int n, int[] tmp){
        int result = 0;

        int min = 1;
        int max = tmp[tmp.length-1];

        while(min <= max){
            int mid = (min + max) / 2;
            int cnt = 0;

            int prev = 0;
            for(int t : tmp){
                if(mid <= t - prev){
                    prev = t;
                }else{
                    cnt++;
                }
            }

            if(cnt > n){
                max = mid - 1;
            }else{
                min = mid + 1;
                result = mid;
            }
        }

        return result;
    }


    // 2, 11, 14, 17, 21, 25
    // 2, 9, 3, 3, 4, 4

    public static void main(String[] args) {
        SteppingStones task = new SteppingStones();

        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;

        System.out.println(task.solution(distance, rocks, n));
    }
}
