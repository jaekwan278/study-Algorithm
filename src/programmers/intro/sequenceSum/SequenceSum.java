package programmers.intro.sequenceSum;

// 연속된 수의 합

// 연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다. 두 정수 num과 total이 주어집니다.
// 연속된 수 num개를 더한 값이 total이 될 때, 정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.

// 1 ≤ num ≤ 100
// 0 ≤ total ≤ 1000
// num개의 연속된 수를 더하여 total이 될 수 없는 테스트 케이스는 없습니다.

import utils.Compare;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SequenceSum {

    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int sum = 0;
        int start = (total / num) - (num  / 2);

        while(true){
            sum = 0;
            for(int i = 0; i < num; i++){
                sum += start + i;
            }

            if(sum == total){
                break;
            }
            else if(sum > total){
                start -= 1;
            }else{
                start += 1;
            }
        }

        for(int i = 0; i < num; i++){
            answer[i] = start + i;
        }

        return answer;
    }

    public int[] solution2(int num, int total) {
        int[] answer = new int[num];

        for(int i = (num - 1); i > 0; i--){
            total -= i;
        }

        int start = total / num;
        for(int i = 0; i < num; i++){
            answer[i] = start + i;
        }

        return answer;
    }

    public int[] solution3(int num, int total) {
        int[] answer = new int[num];
        int check = num*(num+1) / 2;
        int start = (total - check) / num + 1;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = start + i ;
        }
        return answer;
    }

    public int[] solution4(int num, int total){
        int start = (total - (num * (num - 1) / 2)) / num;
        return IntStream.range(start, start+num).toArray();
    }

    public static void main(String[] args) {
        SequenceSum task = new SequenceSum();
        int num = 3;
        int total = 12;

        System.out.println(Arrays.toString(task.solution4(num, total)));

        Compare.measureTime(()->task.solution2(num, total), ()->task.solution3(num, total));
    }
}