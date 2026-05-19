package programmers.practice.coke;

// 콜라 문제

public class Coke {

    public int solution(int a, int b, int n) {
        int answer = 0;

        int empty = n;
        int coke = 0;

        while(empty >= a){
            coke = (empty / a) * b;

            answer += coke;

            empty = (empty % a) + coke;
        }

        return answer;
    }

    public int solution2(int a, int b, int n){
        int answer = 0;

        while(n >= a){
            answer += (n / a) * b;
            n = (n % a) + ((n / a) * b);
        }

        return answer;
    }

    public static void main(String[] args) {
        Coke task = new Coke();
        int a = 3, b = 1, n = 20;

        System.out.println(task.solution2(a, b, n));
    }

}
