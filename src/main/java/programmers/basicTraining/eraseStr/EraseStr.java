package programmers.basicTraining.eraseStr;

// 글자 지우기

import utils.Compare;

import java.util.Arrays;

public class EraseStr {

    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder(my_string);
        Arrays.sort(indices);

        for(int i = indices.length-1; i >= 0; i--){
            sb.deleteCharAt(indices[i]);
        }

        return sb.toString();
    }

    public String solution2(String my_string, int[] indices) {
        String answer = "";
        String[] tmp = my_string.split("");

        for (int i = 0; i < indices.length; i++) {
            tmp[indices[i]] = "";
        }

        for (String x : tmp) {
            answer += x;
        }
        return answer;
    }

    public String solution3(String my_string, int[] indices) {
        String[] str = my_string.split("");
        for (int i=0;i<indices.length;i++) str[indices[i]] = "";
        return String.join("",str);
    }

    public String solution4(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder(my_string);
        for (int i : indices) {
            sb.setCharAt(i, ' ');
        }
        return sb.toString().replace(" ", "");
    }

    public static void main(String[] args) {
        EraseStr task = new EraseStr();
        String my_string = "apporoograpemmemprs";
        int[] indices = {1, 16, 6, 15, 0, 10, 11, 3};

        System.out.println(task.solution(my_string, indices));

        Compare.measureTime(()->task.solution(my_string, indices), ()->task.solution4(my_string, indices));
    }

}
