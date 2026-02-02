package programmers.kakao2021.numberStringAndEnglishWord;

// 숫자 문자열과 영단어

import utils.Compare;

public class NumberStringAndEnglishWord {

    public int solution(String s) {
        String[] nArr = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < nArr.length; i++){
            s = s.replace(nArr[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }

    public int solution2(String s){
        String[] nArr = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder sb = new StringBuilder();

        StringBuilder tmp = new StringBuilder();
        for(char ch : s.toCharArray()){

            if(Character.isDigit(ch)){
                sb.append(ch);
            }else {
                tmp.append(ch);
                for (int i = 0; i < nArr.length; i++) {
                    if (tmp.toString().equals(nArr[i])) {
                        sb.append(i);
                        tmp.setLength(0);
                        break;
                    }
                }
            }
        }

        return Integer.parseInt(sb.toString());
    }


    public static void main(String[] args) {
        NumberStringAndEnglishWord task = new NumberStringAndEnglishWord();
        String s = "one4seveneightone";

        System.out.println(task.solution2(s));

        Compare.measureTime(()->task.solution(s), ()->task.solution2(s));
    }

}
