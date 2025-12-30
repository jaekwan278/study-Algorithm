package programmers.exhaustiveSearch.carpet;

// 카펫

/*

    직사각형을 만들 수 있는 크기 배열

 */

import utils.Compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carpet {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        List<int[]> carpets = getSquares(brown + yellow, 3);
        List<int[]> patterns = getSquares(yellow, 1);

        for(int[] p : patterns){
            for(int[] c : carpets){
                if(c[0] == p[0] + 2 && c[1] == p[1] + 2){
                    answer[0] = c[0];
                    answer[1] = c[1];
                }
            }
        }

        return answer;
    }

    private static List<int[]> getSquares(int size, int idx){
        List<int[]> square = new ArrayList<>();

        for(int i = idx; i <= (int)Math.sqrt(size); i++){
            if(size % i == 0) square.add(new int[]{(size / i), i});
        }

        return square;
    }

    public int[] solution2(int brown, int red) {

        for(int i = 1; i <= red; i++){
            if(red % i == 0){
                int width = red / i;

                if((width + 2)*2 + i*2 == brown){
                    return new int[]{width+2, i+2};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        Carpet task = new Carpet();

        int brown = 24, yellow = 24;

        System.out.println(Arrays.toString(task.solution(brown, yellow)));

        Compare.measureTime(()->task.solution(brown, yellow), ()->task.solution2(brown, yellow));
    }

}


// 6, 18
// 6, 14