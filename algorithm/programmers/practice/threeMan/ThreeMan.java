package programmers.practice.threeMan;

import java.util.Arrays;

// 삼총사

public class ThreeMan {

    public int solution(int[] number) {
        int answer = 0;

        Arrays.sort(number);

        for(int i = 0; i < number.length; i++){
            for(int j = i + 1; j < number.length; j++){
                for(int k = j + 1; k < number.length; k++){
                    if( (number[i] + number[j] + number[k]) == 0 ) answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ThreeMan task = new ThreeMan();
        int[] number = {-3, -2, -1, 0, 1, 2, 3};

        System.out.println(task.solution(number));
    }

}
