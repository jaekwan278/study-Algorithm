package programmers.kakao.baseNgame;

// n 진수 게임

import utils.Compare;

public class BaseNGame {

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        int cur = 0;
        int idx = 0;

        while(answer.length() < t){
            String num = Integer.toString(cur++, n);

            for(int i = 0; i < num.length(); i++){
                if(idx % m == (p - 1)){
                    answer.append(Character.toUpperCase(num.charAt(i)));

                    if(answer.length() >= t) break;
                }
                idx++;
            }
        }

        return answer.toString();
    }

    public String solution2(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        int len = t * m - 1;

        int idx = 0;
        while(sb.length() <= len){
            sb.append(Integer.toString(idx, n));
            idx++;
        }

        for(int i = (p - 1); i <= len; i += m){
            char cur = sb.charAt(i);

            if(Character.isLetter(cur)) cur = Character.toUpperCase(cur);

            answer.append(cur);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        BaseNGame task = new BaseNGame();

        int n = 16, t = 16, m = 2, p = 2;

        System.out.println(task.solution(n, t, m, p));

        Compare.measureTime(()->task.solution(n, t, m, p), ()->task.solution2(n, t, m, p));
    }

}
