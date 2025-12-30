package programmers.greedy.speedCamera;

// 단속 카메라

/*

    [-20, -15]
    [-18, -13]
    [-14, -5]
    [-5, -3]

 */

import java.util.Arrays;

public class SpeedCamera {

    public int solution(int[][] routes) {
        int answer = 0;
        int camera = Integer.MIN_VALUE;

        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        for(int[] r : routes){
            if(camera < r[0]){
                camera = r[1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SpeedCamera task = new SpeedCamera();
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};

        System.out.println(task.solution(routes));
    }

}
