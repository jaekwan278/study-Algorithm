package programmers.practice.numberExpression;

// 숫자의 표현

public class NumberExpression {

//    public int solution(int n) {
//        int answer = 1;
//
//        int next;
//        int max = n / 2;
//        for(int i = 1; i <= max; i++){
//            int sum = next = i;
//
//            while(sum < n){
//                sum += ++next;
//            }
//
//            if(sum == n) answer++;
//        }
//
//        return answer;
//    }

    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i * (i + 1) / 2 <= n; i++){

            int k = n - (i * (i - 1) / 2);

            if(k % i == 0){
                answer ++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        NumberExpression task = new NumberExpression();
        int n = 15;

        System.out.println(task.solution(n));
    }

}
