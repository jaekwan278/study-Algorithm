package programmers.kakao.findPrimeNumberInK;

// k진수에서 소수 개수 구하기

public class FindPrimeNumberInK {

    public int solution(int n, int k) {
        int answer = 0;

        String baseK = Integer.toString(n, k);

        String[] part = baseK.split("0");

        for(String p : part){

            if(p.isEmpty()) continue;

            if(isPrime(Long.parseLong(p))) answer++;

        }

        return answer;
    }

    private boolean isPrime(long num){

        if(num < 2) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;

        for(long i = 3; (i * i) <= num; i += 2){
            if(num % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        FindPrimeNumberInK task = new FindPrimeNumberInK();

        int n = 437674, k = 3;

        System.out.println(task.solution(n, k));
    }

}
