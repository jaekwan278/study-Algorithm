package programmers.basicTraining.listSlicer;

// 리스트 자르기

import utils.Compare;

import java.util.Arrays;

public class ListSlicer {

    public int[] solution(int n, int[] slicer, int[] num_list) {
        switch(n){
            case 1:
                return Arrays.copyOfRange(num_list, 0, slicer[1]+1);
            case 2:
                return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
            case 3:
                return Arrays.copyOfRange(num_list, slicer[0], slicer[1]+1);
            default:
                int[] answer = new int[(slicer[1] - slicer[0]) / slicer[2] + 1];
                int cnt = 0;
                for(int i = slicer[0]; i <= slicer[1]; i += slicer[2]){
                    answer[cnt++] = num_list[i];
                }
                return answer;
        }
    }

    public int[] solution2(int n, int[] slicer, int[] num_list) {
        int start = n == 1 ? 0 : slicer[0];
        int end = n == 2 ? num_list.length - 1 : slicer[1];
        int step = n == 4 ? slicer[2] : 1;
        int[] answer = new int[(end - start + step) / step];
        for (int i = start, j = 0; i <= end; i += step) {
            answer[j++] = num_list[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        ListSlicer task = new ListSlicer();
        int n = 3;
        int[] slicer = {1, 5, 2};
        int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(task.solution(n, slicer, num_list)));

        Compare.measureTime(()->task.solution(n,slicer,num_list), ()->task.solution2(n,slicer,num_list));
    }

}
