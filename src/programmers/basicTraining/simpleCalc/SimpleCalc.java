package programmers.basicTraining.simpleCalc;

// 간단한 식 계산하기

public class SimpleCalc {

    public int solution(String binomial) {
        String[] exp = binomial.split(" ");
        int a = Integer.parseInt(exp[0]);
        int b = Integer.parseInt(exp[2]);

        if(exp[1].equals("+")){
            return a + b;
        }else if(exp[1].equals("-")){
            return a - b;
        }else{
            return a * b;
        }
    }

}
