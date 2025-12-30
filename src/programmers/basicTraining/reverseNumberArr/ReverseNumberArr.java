package programmers.basicTraining.reverseNumberArr;

// 자연수 뒤집어 배열로 만들기

import utils.Compare;

import java.util.Arrays;

public class ReverseNumberArr {

    public int[] solution(long n) {

        if(n == 0) return new int[]{0};

        String str = String.valueOf(n);
        int length = str.length();

        int[] answer = new int[length];

        for(int i = 0; i < length; i++){
            answer[i] = (int) (n % 10);
            n /= 10;
        }

        return answer;
    }

    public int[] solution2(long n){
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }

    public static void main(String[] args) {
        ReverseNumberArr task = new ReverseNumberArr();
        long n = 12345;

        System.out.println(Arrays.toString(task.solution2(n)));

        Compare.measureTime(()->task.solution(n), ()->task.solution2(n));
    }

}
