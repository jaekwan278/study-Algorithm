package programmers.basicTraining.getRemainderBy9;

// 9로 나눈 나머지

public class GetRemainderBy9 {

    public int solution(String number) {
        int answer = 0;

        for(char ch : number.toCharArray()){
            answer += ch - '0';
        }

        return answer % 9;
    }

    public static void main(String[] args) {
        GetRemainderBy9 task = new GetRemainderBy9();
        String number = "78720646226947352489";

        System.out.println(task.solution(number));
    }

}
