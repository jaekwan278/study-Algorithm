package programmers.intro.hateEnglish;

// 영어가 싫어요

// 영어가 싫은 머쓱이는 영어로 표기되어있는 숫자를 수로 바꾸려고 합니다. 문자열
// numbers가 매개변수로 주어질 때, numbers를 정수로 바꿔 return 하도록
// solution 함수를 완성해 주세요.

public class HateEnglish {
    public long solution(String numbers) {
        long answer = 0;
        String[] numStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        int cnt = 0;
        for(String str : numStr){
            numbers = numbers.replaceAll(numStr[cnt], cnt+"");
            cnt++;
        }
        answer = Long.parseLong(numbers);

        return answer;
    }

    public static void main(String[] args) {
        HateEnglish task = new HateEnglish();
        String str = "onefourzerosixsevenseven";

        System.out.println(task.solution(str));
    }
}
