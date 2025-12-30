package programmers.basicTraining.caseConverter;

// 배열에서 문자열 대소문자 변환하기

import java.util.Arrays;

public class CaseConverter {

    public String[] solution(String[] strArr) {

        for(int i = 0; i < strArr.length; i++){
            if(i % 2 == 0) strArr[i] = strArr[i].toLowerCase();
            else strArr[i] = strArr[i].toUpperCase();
        }

        return strArr;
    }

    public static void main(String[] args) {
        CaseConverter task = new CaseConverter();
        String[] strArr = {"AAA","BBB","CCC","DDD"};

        System.out.println(Arrays.toString(task.solution(strArr)));
    }

}
