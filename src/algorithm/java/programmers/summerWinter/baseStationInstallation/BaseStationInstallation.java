package programmers.summerWinter.baseStationInstallation;

// 기지국 설치

import java.util.Arrays;

public class BaseStationInstallation {
    // try 1 ( over time )
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for(int cur : stations){

            int left = Math.max(cur - w - 1, 0);
            int right = Math.min(cur + w, n);

            Arrays.fill(visited, left, right, true);

        }

        int len = w * 2 + 1;
        for(int i = 0; i < visited.length; i++){

            if(visited[i]) continue;

            int cnt = 0;
            while(i < visited.length && !visited[i]){
                cnt++;
                i++;
            }

            answer += (cnt % len > 0) ? cnt / len + 1 : cnt / len;

            i--;
        }

        return answer;
    }

    // try 2 ( pass )
    public int solution2(int n, int[] stations, int w){
        int answer = 0;

        int range = w * 2 + 1;

        int left = 1;
        for(int cur : stations){

            int right = cur - w;
            int gap = right - left;

            if(gap > 0){
                int cnt = (range + gap - 1) / range;
                answer += cnt;
            }

            left = cur + w + 1;
        }

        if(left <= n){
            int gap = n - left + 1;
            int cnt = (range + gap - 1) / range;
            answer += cnt;
        }

        return answer;
    }

    // other solution 1
    public int solution3(int n, int[] stations, int w) {
        int answer = 0;
        int s=0;
        int left =1;
        while(true){
            if(s < stations.length && left >= stations[s] - w){
                left = stations[s]+w+1;
                s++;
            }
            else{
                left=left+w+w+1;
                answer++;
            }
            if(left> n){
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        BaseStationInstallation task = new BaseStationInstallation();

        int n = 11;
        int[] stations = {4, 11};
        int w = 1;

        System.out.println(task.solution2(n, stations, w));
    }

}
