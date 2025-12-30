package programmers.intro.additionFraction;

import utils.Compare;

import java.util.Arrays;

// 분수의 덧셈

// 첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
// 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.

public class AdditionFraction {

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];

        int gcd = gcd(denom1, denom2);
        answer[1] = denom1 * denom2 / gcd;
        answer[0] = (numer1 * (answer[1] / denom1)) + (numer2 * (answer[1] / denom2));

        gcd = gcd(answer[0], answer[1]);
        answer[0] /= gcd;
        answer[1] /= gcd;

        return answer;
    }

    public int[] solution2(int numer1, int denom1, int numer2, int denom2) {
        int numer = (numer1 * denom2) + (numer2 * denom1);
        int denom = denom1 * denom2;

        int gcd = gcd(numer, denom);

        return new int[]{(numer/gcd), (denom/gcd)};
    }

    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        AdditionFraction task = new AdditionFraction();
        int numer1 = 1, numer2 = 3;
        int denom1 = 2, denom2 = 4;

        Compare.measureTime(() -> task.solution(numer1, denom1, numer2, denom2), () -> task.solution2(numer1, denom1, numer2, denom2));

        System.out.println(Arrays.toString(task.solution2(numer1, denom1, numer2, denom2)));
    }

}
