package programmers.basicTraining.stringRepeater;

// 문자열 반복해서 출력하기

import java.util.Scanner;

public class StringRepeater {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        System.out.println(str.repeat(n));
    }

}
