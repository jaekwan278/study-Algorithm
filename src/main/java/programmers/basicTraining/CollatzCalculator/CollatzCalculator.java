package programmers.basicTraining.CollatzCalculator;

// 콜라츠 추측

import utils.Compare;

public class CollatzCalculator {
    public int solution(int num) {
        int answer = 0;

        while(num != 1 && answer < 499){
            if(num % 2 == 1){
                num = num * 3 + 1;
            }else{
                num /= 2;
            }
            answer++;
        }

        return (answer == 499) ? -1 : answer;
    }

    public int collatz(int num) {
        long n = (long)num;
        for(int i=0; i<500; i++){
            if(n==1) return i;
            n = (n%2==0) ? n/2 : n*3+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        CollatzCalculator task = new CollatzCalculator();
        int num = 626331;

        System.out.println(task.solution(num));

        Compare.measureTime(()->task.solution(num), ()->task.collatz(num));
    }
}
