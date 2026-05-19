package programmers.basicTraining.makeArray5;

// 배열 만들기 5

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeArray5 {

    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();

        for(String str : intStrs){
            int result = Integer.parseInt(str.substring(s, (s + l)));
            if(result > k) list.add(result);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        MakeArray5 task = new MakeArray5();
        String[] intStrs = {"0123456789","9876543210","9999999999999"};
        int k = 50000, s = 5, l = 5;

        System.out.println(Arrays.toString(task.solution(intStrs, k, s, l)));
    }

}
