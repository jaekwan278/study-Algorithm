package programmers.basicTraining.partOfInteger;

// 정수 부분

public class PartOfInteger {

    public int solution(double flo) {

        return (int) flo;
    }

    public static void main(String[] args) {
        PartOfInteger task = new PartOfInteger();
        double flo = 1.82;

        System.out.println(task.solution(flo));
    }
}
