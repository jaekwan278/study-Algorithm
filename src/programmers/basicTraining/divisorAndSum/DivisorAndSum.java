package programmers.basicTraining.divisorAndSum;

// 약수의 개수와 덧셈

public class DivisorAndSum {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++){

            if(countDivisor(i) % 2 == 0) answer += i;
            else answer -= i;
        }

        return answer;
    }

    public int countDivisor(int num){
        int count = 0;
        for(int i = 1; i * i <= num; i++){
            if(num % i == 0){
                count++;
                if(i != (num / i)) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DivisorAndSum task = new DivisorAndSum();
        int left = 13, right = 17;

        System.out.println(task.solution(left, right));
    }
}
