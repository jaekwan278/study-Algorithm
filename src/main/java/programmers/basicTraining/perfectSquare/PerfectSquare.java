package programmers.basicTraining.perfectSquare;

public class PerfectSquare {

    public long solution(long n) {
        long answer = -1;
        double sqrt = Math.sqrt(n);

        if(sqrt == (int)sqrt){
            return (long)Math.pow((sqrt+1), 2);
        }

        return answer;
    }

}
