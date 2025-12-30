package programmers.basicTraining.sumUntilOverN;

// n 보다 커질 때 까지 더하기

public class SumUntilOverN {

    public int solution(int[] numbers, int n) {
        int answer = 0;

        int cnt = 0;
        while(answer <= n){
            answer += numbers[cnt];
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args) {

        SumUntilOverN task = new SumUntilOverN();
        int[] numbers = {34, 5, 71, 29, 100, 34};
        int n = 123;

        System.out.println(task.solution(numbers, n));

    }
}
