package programmers.montlyChallenge.ternaryReverser;

// 3진법 뒤집기

public class TernaryReverser {

    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            sb.append(n % 3);
            n = n / 3;
        }

        answer = Integer.parseInt(sb.toString(), 3);

        return answer;
    }

    public static void main(String[] args) {
        TernaryReverser task = new TernaryReverser();
        int n = 45;

        System.out.println(task.solution(45));
    }

}
