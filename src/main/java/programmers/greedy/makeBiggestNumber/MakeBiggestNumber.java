package programmers.greedy.makeBiggestNumber;

// 큰 수 만들기

import utils.Compare;

import java.util.ArrayDeque;

public class MakeBiggestNumber {

    public String solution(String number, int k) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(char ch : number.toCharArray()){

            while(!stack.isEmpty() && k > 0 && stack.peekLast() < ch){
                stack.pollLast();
                k--;
            }

            stack.addLast(ch);
        }

        while(k > 0){
            stack.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(Character ch : stack){
            sb.append(ch);
        }

        return sb.toString();
    }

    public String solution2(String number, int k){
        StringBuilder sb = new StringBuilder();

        for(char ch : number.toCharArray()){

            while(!sb.isEmpty() && k > 0 && sb.charAt(sb.length()-1) < ch){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }

            sb.append(ch);
        }

        while(k > 0){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MakeBiggestNumber task = new MakeBiggestNumber();
        String number = "4177252841";
        int k = 1;

        System.out.println(task.solution2(number, k));

        Compare.measureTime(()->task.solution(number, k), ()->task.solution2(number, k));
    }

}
