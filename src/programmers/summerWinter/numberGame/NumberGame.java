package programmers.summerWinter.numberGame;

// 숫자 게임

import java.util.Arrays;

public class NumberGame {

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int idx = 0;
        for(int target : A){

            for(int j = idx; j < B.length; j++){

                if(B[j] > target){
                    answer++;
                    idx = j + 1;
                    break;
                }
            }

            if(idx > B.length) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        NumberGame task = new NumberGame();

        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        /*
        1 3 5 7
        2 2 6 8
         */

        System.out.println(task.solution(A, B));
    }

}
