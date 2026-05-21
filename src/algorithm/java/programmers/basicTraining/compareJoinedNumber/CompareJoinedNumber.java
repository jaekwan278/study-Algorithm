package programmers.basicTraining.compareJoinedNumber;

// 더 크게 합치기

public class CompareJoinedNumber {

    public int solution(int a, int b) {
        return Math.max(Integer.parseInt(a + "" + b), Integer.parseInt(b + "" + a));
    }

    public static void main(String[] args) {
        CompareJoinedNumber task = new CompareJoinedNumber();
        int a = 89, b = 8;

        System.out.println(task.solution(a, b));
    }

}
