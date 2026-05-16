package programmers.intro.countSeven;

import utils.Compare;

import java.util.Arrays;

public class CountSeven {
    public int solutionA(int[] array) {
        String arrStr = Arrays.toString(array);

        String str = arrStr.replaceAll("[^7]", "");

        return str.length();
    }
    public int solutionB(int[] array) {
        int answer = 0;
        for(int a : array){
            while(a != 0){
                if(a % 10 == 7){
                    answer++;
                }
                a /= 10;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CountSeven task = new CountSeven();
        int[] arr = {7, 77, 17};
        Compare.measureTime(()-> task.solutionA(arr), ()->task.solutionB(arr));
    }
}
