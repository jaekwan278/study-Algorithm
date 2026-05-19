package programmers.basicTraining.missingNumberSum;

// 없는 숫자 더하기

public class MissingNumberSum {

    public int solution(int[] numbers) {
        int answer = 9 * 10 / 2;

        for(int num : numbers){
            answer -= num;
        }

        return answer;
    }

    public static void main(String[] args) {
        MissingNumberSum task = new MissingNumberSum();
        int[] numbers = {1,2,3,4,6,7,8,0};

        System.out.println(task.solution(numbers));
    }

}
