package programmers.basicTraining.findRemainedOne;

// 나머지가 1이 되는 수 찾기

import utils.Compare;

public class FindRemainedOne {

    public int solution(int n) {
        int answer = 2;

        while(answer <= (n-1)){
            if(n % answer == 1) return answer;
            answer++;
        }

        return answer;
    }

    public int solution2(int n){
        int answer = n - 1;

        for(int i = 2; i <= Math.sqrt(answer); i++){
            if(answer % i == 0) return i;
        }

        return answer;
    }

    public static void main(String[] args) {
        FindRemainedOne task = new FindRemainedOne();
        int n = 12;

        System.out.println(task.solution2(n));

        Compare.measureTime(()->task.solution(n),()->task.solution2(n));
    }

}
