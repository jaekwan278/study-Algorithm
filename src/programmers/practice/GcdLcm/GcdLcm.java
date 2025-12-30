package programmers.practice.GcdLcm;

// 최대 공약수와 최소 공배수

import java.util.Arrays;

public class GcdLcm {

    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int gcd = gcd(n, m);
        answer[0] = gcd;
        answer[1] = n * m / gcd;

        return answer;
    }

    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        GcdLcm task = new GcdLcm();
        int n = 2, m = 5;

        System.out.println(Arrays.toString(task.solution(n, m)));
    }

}
