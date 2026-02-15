package programmers.tipsTown2017.expectedBracket;

// 예상 대진표

public class ExpectedBracket {

    public int solution(int n, int a, int b)
    {
        int answer = 0;


        while(a != b){

            a = (a + 1) / 2;
            b = (b + 1) / 2;

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        ExpectedBracket task = new ExpectedBracket();

        int n = 8, a = 4, b = 7;

        System.out.println(task.solution(n, a, b));
    }

}
