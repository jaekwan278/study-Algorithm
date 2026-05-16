package programmers.intro.distributeBead;

// 구슬을 나누는 경우의 수

// 머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 구슬은 모두 다르게 생겼습니다.
// 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수
// share이 매개변수로 주어질 때, balls개의 구슬 중 share개의 구슬을 고르
// 는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.

import utils.Compare;

import java.math.BigInteger;

public class DistributeBead {

    public int solution(int balls, int share) {
        int answer = 0;

        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");

        for(int i = 0; i < share; i++){
            a = a.multiply(BigInteger.valueOf(balls - i));
            b = b.multiply(BigInteger.valueOf(i + 1));
        }

        answer = (a.divide(b)).intValue();

        return answer;
    }

    // 재귀 함수
    public int solution2(int balls, int share){
        share = Math.min(balls - share, share);

        if(share == 0){
            return 1;
        }

        long result = solution2(balls - 1, share - 1);
        result *= balls;
        result /= share;

        return (int)result;
    }

    public static void main(String[] args) {
        DistributeBead task = new DistributeBead();
        int balls = 30, share = 14;

        // balls 30 share 20 == balls 30 share 10

        Compare.measureTime(()-> task.solution(balls, share), ()-> task.solution2(balls, share));
    }

}
