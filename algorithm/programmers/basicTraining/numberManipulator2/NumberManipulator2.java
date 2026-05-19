package programmers.basicTraining.numberManipulator2;

// 수 조작하기 2

public class NumberManipulator2 {

    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();

        int curr = numLog[0];

        for(int i = 1; i < numLog.length; i++){

            if(numLog[i] == curr + 1){
                sb.append("w");
            }else if(numLog[i] == curr - 1){
                sb.append("s");
            }else if(numLog[i] == curr + 10){
                sb.append("d");
            }else{
                sb.append("a");
            }

            curr = numLog[i];
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        NumberManipulator2 task = new NumberManipulator2();
        int[] numLog = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};

        System.out.println(task.solution(numLog));
    }

}
