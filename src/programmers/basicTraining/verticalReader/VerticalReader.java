package programmers.basicTraining.verticalReader;

// 세로 읽기

import utils.Compare;

import java.util.ArrayList;
import java.util.List;

public class VerticalReader {

    public String solution(String my_string, int m, int c) {

        List<String> list = new ArrayList<>();
        for(int i = 0; i < (my_string.length() / m); i++){
            list.add(my_string.substring(i * m, (i + 1) * m));
        }

        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str.charAt(c-1));
        }

        return sb.toString();
    }

    public String solution2(String my_string, int m, int c){
        String answer = "";
        for(;c < my_string.length(); c += m){
            answer += my_string.charAt(c-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        VerticalReader task = new VerticalReader();
        String my_string = "ihrhbakrfpndopljhygc";
        int m = 4, c = 2;

        System.out.println(task.solution2(my_string, m, c));

        Compare.measureTime(()->task.solution(my_string, m, c), ()->task.solution2(my_string, m, c));
    }

}
