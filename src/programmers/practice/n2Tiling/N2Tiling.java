package programmers.practice.n2Tiling;

// 2 x n 타일링

public class N2Tiling {

    public int solution(int n) {
        int answer = 0;

        int a = 1;
        int b = 2;

        for(int i = 3; i <= n; i++){
            answer = (a + b) % 1_000_000_007;

            a = b;
            b = answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        N2Tiling task = new N2Tiling();

        int n = 10;

        System.out.println(task.solution(n));
    }
}
