package programmers.basicTraining.stringWithCondition;

// 조건 문자열

public class StringWithCondition {

    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        String sign = ineq + eq;

        switch (sign){
            case ">=":
                return n >= m ? 1 : 0;
            case "<=":
                return n <= m ? 1 : 0;
            case ">!":
                return n > m ? 1 : 0;
            case "<!":
                return n < m ? 1 : 0;
        }

        return answer;
    }

}
