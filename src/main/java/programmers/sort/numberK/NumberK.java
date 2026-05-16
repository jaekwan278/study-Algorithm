package programmers.sort.numberK;

import utils.Compare;

import java.util.Arrays;

// K번째 수

public class NumberK {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int pointer = 0;
        for(int[] command : commands){
            int[] arr = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(arr);
            answer[pointer++] = arr[command[2]-1];
        }

        return answer;
    }

    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        NumberK task = new NumberK();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(task.solution(array, commands)));

        Compare.measureTime(()->task.solution(array, commands), ()->task.solution2(array, commands));
    }
}
