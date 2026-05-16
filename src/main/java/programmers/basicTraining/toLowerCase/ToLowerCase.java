package programmers.basicTraining.toLowerCase;

// 소문자로 바꾸기

import utils.Compare;

public class ToLowerCase {

    public String solution(String myString) {
        return myString.toLowerCase();
    }

    public String solution2(String myString) {
        StringBuilder sb = new StringBuilder();
        for(char k : myString.toCharArray()){
            sb.append(Character.toLowerCase(k));
        }
        String answer = String.valueOf(sb);
        return answer;
    }

    public static void main(String[] args) {
        ToLowerCase task = new ToLowerCase();
        String myString = "aBcDeFg";

        Compare.measureTime(()->task.solution(myString), ()->task.solution2(myString));
    }

}
