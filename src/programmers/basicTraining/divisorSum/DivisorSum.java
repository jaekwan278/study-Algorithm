package programmers.basicTraining.divisorSum;

public class DivisorSum {

    public int solution(int n) {
        int answer = 0;

        if(n == 0) return 0;

        for(int i = 1; i <= Math.sqrt(n); i++){
            if((n % i) == 0){
                answer += i;
                if(i != (n / i)){
                    answer += (n / i);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        DivisorSum task = new DivisorSum();
        int n = 12;

        System.out.println(task.solution(n));
    }

}
