package programmers.basicTraining.valueComparator;

// 두 수의 연산값 비교하기

public class ValueComparator {

    public int solution(int a, int b) {
        int n = Integer.parseInt(a + "" + b);
        int m = 2 * a * b;

        return Math.max(n, m);
    }

    public static void main(String[] args) {
        ValueComparator task = new ValueComparator();
        int a = 91, b = 2;

        System.out.println(task.solution(a, b));
    }

}
