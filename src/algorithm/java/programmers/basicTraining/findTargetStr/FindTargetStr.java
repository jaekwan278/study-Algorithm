package programmers.basicTraining.findTargetStr;

// 원하는 문자열 찾기

import utils.Compare;

public class FindTargetStr {

    public int solution(String myString, String pat) {

        return myString.toUpperCase().contains(pat.toUpperCase()) ? 1 : 0;
    }

    public int solution2(String myString, String pat) {
        int answer = 0;
        String str = myString.toLowerCase();
        String str2 = pat.toLowerCase();

        if (str.indexOf(str2) != -1) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        FindTargetStr task = new FindTargetStr();
        String myString = "AbCdEfG";
        String pat = "aBc";

        System.out.println(task.solution(myString, pat));

        Compare.measureTime(()->task.solution(myString, pat), ()->task.solution2(myString, pat));
    }

}
