package programmers.basicTraining.commonMultiple;

public class CommonMultiple {

    public int solution(int number, int n, int m) {
       return (number % n == 0 && number % m == 0) ? 1 : 0;
    }

    public static void main(String[] args) {
        CommonMultiple task = new CommonMultiple();
        int number = 60, n = 2, m = 3;

        System.out.println(task.solution(number, n, m));
    }

}
