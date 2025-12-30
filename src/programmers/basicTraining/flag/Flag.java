package programmers.basicTraining.flag;

// flag 에 따라 다른 값 반환하기

public class Flag {

    public int solution(int a, int b, boolean flag) {
        int answer = 0;

        answer = (flag) ? (a + b) : (a - b);

        return answer;
    }

    public static void main(String[] args) {
        Flag task = new Flag();
        int a = -4, b = 7;
        boolean flag = false;

        System.out.println(task.solution(a, b, flag));
    }

}
