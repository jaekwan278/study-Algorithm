package programmers.pcce.divideNumber;

// 수 나누기

/*

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int answer = 0;

        for(int i=0; i<1; i++){
            answer += number % 100;
            number /= 100;
        }

        System.out.println(answer);
    }
}

 */

import java.util.Scanner;

public class DivideNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int answer = 0;

        while(number > 0){
            answer += number % 100;
            number /= 100;
        }

        System.out.println(answer);
    }
}

// 4859 ->
//  48 + 0 = 48
//  48
