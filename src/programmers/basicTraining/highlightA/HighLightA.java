package programmers.basicTraining.highlightA;

// A 강조하기

import utils.Compare;

public class HighLightA {

    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();

        for (char ch : myString.toCharArray()) {
            if (ch == 'a' || ch == 'A') {
                sb.append('A');
            } else {
                sb.append(Character.toLowerCase(ch));
            }
        }

        return sb.toString();
    }

    public String solution2(String myString) {
        return myString.chars()
                .map(ch -> (ch == 'a' || ch == 'A') ? Character.toUpperCase(ch) : Character.toLowerCase(ch))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String solution3(String myString){
        return myString.toLowerCase().replaceAll("a", "A");
    }

    public static void main(String[] args) {
        HighLightA task = new HighLightA();
        String myString = "abstract algebra";

        System.out.println(task.solution3(myString));

        Compare.measureTime(()-> task.solution(myString), ()-> task.solution3(myString));
    }

}
