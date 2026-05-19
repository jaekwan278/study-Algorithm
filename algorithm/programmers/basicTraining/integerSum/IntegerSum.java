package programmers.basicTraining.integerSum;

// 두 수의 합

import java.math.BigInteger;

public class IntegerSum {

    public String solution(String a, String b) {
        BigInteger bigA = new BigInteger(a);
        BigInteger bigB = new BigInteger(b);

        return bigA.add(bigB) + "";
    }

    public static void main(String[] args) {
        IntegerSum task = new IntegerSum();
        String a = "18446744073709551615", b = "287346502836570928366";

        System.out.println(task.solution(a, b));
    }
}
