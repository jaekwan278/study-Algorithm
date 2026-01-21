package programmers.practice.fibonacci;

// 피보나치 수

public class Fibonacci {

    public int solution(int n) {
        int answer = 0;
        final int div = 1234567;

        int prev2 = 0;
        int prev1 = 1;

        for(int i = 2; i <= n; i++){
            answer = (prev2 + prev1) % div;
            prev2 = prev1;
            prev1 = answer;

        }

        return answer;
    }

    public static void main(String[] args) {
        Fibonacci task = new Fibonacci();
        int n = 5;

        System.out.println(task.solution(n));
    }

}
