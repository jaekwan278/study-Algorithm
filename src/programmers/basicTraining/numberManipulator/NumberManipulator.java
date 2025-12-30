package programmers.basicTraining.numberManipulator;

// 수 조작하기 1

public class NumberManipulator {

    public int solution(int n, String control) {
        int answer = n;

        for(char ch : control.toCharArray()){
            switch (ch){
                case 'w' : answer += 1; break;
                case 's' : answer -= 1; break;
                case 'd' : answer += 10; break;
                default : answer -= 10; break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        NumberManipulator task = new NumberManipulator();
        int n = 0;
        String control = "wsdawsdassw";

        System.out.println(task.solution(n, control));
    }

}
