package programmers.basicTraining.sumBetweenInt;

// 두 정수 사이의 합

public class SumBetweenInt {

    public long solution(int a, int b) {
        return (long)(a + b) * (Math.abs(a - b) + 1) / 2;
    }

    public static void main(String[] args) {
        SumBetweenInt task = new SumBetweenInt();
        int a = 3, b = 5;

        System.out.println(task.solution(a, b));
    }
}
