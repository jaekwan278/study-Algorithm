package programmers.intro.calcStr;

// my_string은 "3 + 5"처럼 문자열로 된 수식입니다. 문자열 my_string이 매개
// 변수로 주어질 때, 수식을 계산한 값을 return 하는 solution 함수를 완성해주세요.

// my_string의 숫자와 연산자는 공백 하나로 구분되어 있습니다.

import utils.Compare;

import java.util.Arrays;

public class CalcStr {
    public int solution(String my_string) {
        int answer = 0;

        String[] arr = my_string.trim().split("\\s+");
        answer = Integer.parseInt(arr[0]);

        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i].equals("+")){
                answer += Integer.parseInt(arr[i+1]);
            }else if(arr[i].equals("-")){
                answer -= Integer.parseInt(arr[i+1]);
            }
        }

        return answer;
    }
    public int solution2(String my_string){
        int answer = 0;

        answer =
                Arrays.stream(my_string
                        .replaceAll("- ", "-")
                        .replaceAll("[+] ", "")
                        .split(" "))
                        .mapToInt(Integer::parseInt)
                        .sum();

        return answer;
    }

    public static void main(String[] args) {
        CalcStr task = new CalcStr();
        String str = "3 + 4";
        Compare.measureTime(() -> task.solution(str), () -> task.solution2(str));
    }
}
