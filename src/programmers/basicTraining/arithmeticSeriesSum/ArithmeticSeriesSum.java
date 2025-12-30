package programmers.basicTraining.arithmeticSeriesSum;

// 등차수열의 특정한 항만 더하기


public class ArithmeticSeriesSum {

    public int solution(int a, int d, boolean[] included) {
        int answer = 0;

        for(int i = 0; i < included.length; i++){
            if(included[i]) answer += a + i * d;
        }

        return answer;
    }

    public static void main(String[] args) {
        ArithmeticSeriesSum task = new ArithmeticSeriesSum();
        int a = 3, b = 4;
        boolean[] included = {true, false, false, true, true};

        System.out.println(task.solution(a, b, included));
    }
}
