package programmers.basicTraining.toggleCasePrint;

// 대소문자 바꿔서 출력하기

import java.util.Scanner;

public class ToggleCasePrint {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder sb = new StringBuilder();

        for(char ch : a.toCharArray()){
            if(Character.isUpperCase(ch)) sb.append(Character.toLowerCase(ch));
            else sb.append(Character.toUpperCase(ch));
        }

        System.out.println(sb);
    }

}
