package programmers.basicTraining.convertOdd;

import utils.Compare;

public class ConvertOdd {

    public int solution(int n) {
        int odd = 0;
        int even = 0;
        int cnt = n;

        while(cnt > 0){
            if(cnt % 2 == 0){
                even += (int)Math.pow(cnt, 2);
            }else{
                odd += cnt;
            }
            cnt--;
        }

        return (n % 2 == 0) ? even : odd;
    }

    public int solution2(int n) {
        int answer = 0;

        for(int i = n; i >= 0; i -= 2)
            answer += (n % 2 == 0) ? i * i : i;

        return answer;
    }

    public int solution3(int n) {
        if (n % 2 == 1) {
            return (n + 1) * (n + 1) / 2 / 2;
        } else {
            return 4 * n/2 * (n/2 + 1) * (2 * n/2 + 1) / 6;
        }
    }

    public static void main(String[] args) {
        ConvertOdd task = new ConvertOdd();
        int n = 52;

        System.out.println(task.solution(n));

        Compare.measureTime(()->task.solution(n), ()->task.solution2(n));
    }

}
