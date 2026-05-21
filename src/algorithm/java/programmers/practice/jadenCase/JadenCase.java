package programmers.practice.jadenCase;

// JadenCase 문자열 만들기

import utils.Compare;

public class JadenCase {

    public String solution(String s) {
        char[] strArr = s.toCharArray();
        StringBuilder sb = new StringBuilder(s.length());
        boolean isFirst = true;

        for(int i = 0; i < s.length(); i++){
            char ch = strArr[i];
            if(Character.isWhitespace(ch)){
                sb.append(ch);
                isFirst = true;
            }else{
                if(isFirst){
                    sb.append(Character.toUpperCase(ch));
                    isFirst = false;
                }else{
                    sb.append(Character.toLowerCase(ch));
                }
            }
        }

        return sb.toString();
    }

    public String solution2(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }

    public static void main(String[] args) {
        JadenCase task = new JadenCase();
        String s = "3people unFollowed me";

        System.out.println(task.solution(s));

        Compare.measureTime(()->task.solution(s), ()->task.solution2(s));
    }

}
