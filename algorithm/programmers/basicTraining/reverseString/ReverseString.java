package programmers.basicTraining.reverseString;

// 문자열 뒤집기

import utils.Compare;

public class ReverseString {

    public String solution(String my_string, int s, int e) {
        String head = my_string.substring(0, s);
        String tail = my_string.substring(e+1);

        StringBuilder body = new StringBuilder(my_string.substring(s, e+1));
        body.reverse();

        return head + body + tail;
    }

    public String solution2(String my_string, int s, int e){
        StringBuilder sb = new StringBuilder(my_string);

        while(s < e){
            char tmp = sb.charAt(s);
            sb.setCharAt(s, sb.charAt(e));
            sb.setCharAt(e, tmp);
            s++;
            e--;
        }

        return sb.toString();
    }

    public String solution3(String my_string, int s, int e) {

        char[] arr = my_string.toCharArray();
        while (s < e) {
            char temp = arr[s];
            arr[s++] = arr[e];
            arr[e--] = temp;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        ReverseString task = new ReverseString();
        String my_string = "Progra21Sremm3";
        int s = 6, e = 12;

        System.out.println(task.solution2(my_string, s, e));

        Compare.measureTime(() -> task.solution2(my_string, s, e), () -> task.solution3(my_string, s, e));
    }

}
