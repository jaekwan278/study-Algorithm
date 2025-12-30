package programmers.intro.closeNum;

// 가까운 수
// 정수 배열 array와 정수 n이 매개변수로 주어질 때, array에 들어있는 정수
// 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.

import utils.Compare;

import java.util.Arrays;

public class CloseNum {

    public int solutionA(int[] array, int n) {
        int answer = 0;

        int[] sorted = array.clone();

        Arrays.sort(sorted);

        int index = 0;

        if (sorted[sorted.length - 1] < n) {
            return sorted[sorted.length - 1];
        } else if (sorted[0] > n) {
            return sorted[0];
        }

        for (int num : sorted) {
            if (num > n) {
                break;
            }
            index++;
        }

        if (array[index - 1] == array[index]) {
            return array[index - 1];
        }

        answer = ((n - sorted[index - 1]) > (sorted[index] - n)) ? sorted[index] : sorted[index - 1];

        return answer;
    }

    public int solutionB(int[] array, int n) {
        int answer = 0;
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if (Math.abs(n - array[0]) > Math.abs(n - array[i])) {
                array[0] = array[i];
            }
        }
        answer = array[0];
        return answer;
    }

    public static void main(String[] args) {
        CloseNum task = new CloseNum();

        Compare.measureTime(
                () -> task.solutionA(new int[]{10, 11, 12, 24, 28}, 22),
                () -> task.solutionB(new int[]{10, 11, 12, 24, 28}, 22)
        );
    }

}
