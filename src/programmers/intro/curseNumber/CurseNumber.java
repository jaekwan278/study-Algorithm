package programmers.intro.curseNumber;

// 저주의 숫자

// 3x 마을 사람들은 3을 저주의 숫자라고 생각하기 때문에 3의 배수와 숫자 3을 사용하지 않습니다. 3x 마을 사람들의 숫자는 다음과 같습니다.
// 10진법	3x 마을에서 쓰는 숫자	10진법	3x 마을에서 쓰는 숫자
// 1	    1	                6	    8
// 2	    2	                7	    10
// 3	    4	                8	    11
// 4	    5	                9	    14
// 5	    7	                10	    16
// 정수 n이 매개변수로 주어질 때, n을 3x 마을에서 사용하는 숫자로 바꿔 return하도록 solution 함수를 완성해주세요.

// 30 ~ -> 31, 32, 34, 35, 37, 38 -> 6
// 60 ~ -> 61, 62, 64, 65,

import utils.Compare;

public class CurseNumber {
    public int solution(int n) {
        return calcNumber(n, 1);
    }

    public int calcNumber(int n, int cnt){

        String str = String.valueOf(cnt);

        if(str.contains("3") || (cnt % 3) == 0){
            return calcNumber(n, cnt+1);
        }

        if(n == 1) return cnt;

        return calcNumber(n-1, cnt+1);
    }

    public int solution2(int n){
        int cnt = 0;
        int answer = 0;

        while(cnt < n){
            answer++;
            String str = String.valueOf(answer);
            if(str.contains("3") || answer % 3 == 0){
                continue;
            }
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        CurseNumber task = new CurseNumber();
        int n = 10;
        System.out.println("결과 : " + task.solution2(n));
        Compare.measureTime(()-> task.solution(n), ()-> task.solution2(n));
    }
}
