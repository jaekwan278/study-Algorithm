package programmers.basicTraining.rotateString;

// 문자열 돌리기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RotateString {


    private static void solution(String str){
        for(char ch : str.toCharArray()){
            System.out.println(ch);
        }
    }

    private static void solution2(String str) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(char ch : br.readLine().toCharArray()){
            System.out.println(ch);
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        solution(a);
        solution2(a);
    }

}
