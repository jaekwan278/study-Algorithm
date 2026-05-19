package programmers.practice.findPrimeNumber;

// 소수 찾기

import utils.Compare;

import java.util.BitSet;

public class FindPrimeNumber {
    // 에라토스테네스 체
    public int solution(int n) {
        int answer = 0;

        boolean[] isPrime = new boolean[n + 1];
        isPrime[0] = isPrime[1] = true;

        for(int i = 2; i <= n; i++){

            if(isPrime[i]) continue;

            for(int j = (i * 2); j <= n; j += i){
                isPrime[j] = true;
            }
        }

        for(boolean b : isPrime){
            if(!b) answer++;
        }

        return answer;
    }

    // 에라토스테네스 체 + BitSet ( 메모리 효율 : BitSet(64bit * n))
    public int solution2(int n) {
        BitSet isPrime = new BitSet(n+1);
        isPrime.set(0);
        isPrime.set(1);

        for(int i = 2; (i * i) <= n; i++){

            if(isPrime.get(i)) continue;

            for(int j = (i * i); j <= n; j += i){
                isPrime.set(j);
            }

        }

        return (n + 1) - isPrime.cardinality();
    }

    // 홀수만 판별 -> 짝수는 합성수
    public int solution3(int n) {
        int answer = 1;

        boolean[] composite = new boolean[n + 1];

        for(int i = 3; (i * i) <= n; i += 2){

            if(!composite[i]){

                for(int j = (i * i); j <= n; j += (2 * i)){
                    composite[j] = true;
                }

            }
        }

        for(int i = 3; i <= n; i += 2){
            if(!composite[i]) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        FindPrimeNumber task = new FindPrimeNumber();

        int n = 10;

        System.out.println(task.solution2(n));

        Compare.measureTime(()->task.solution(n), ()->task.solution2(n));
    }
}
