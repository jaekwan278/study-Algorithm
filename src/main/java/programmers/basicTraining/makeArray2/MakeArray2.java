package programmers.basicTraining.makeArray2;

// 배열 만들기 2

import utils.Compare;

import java.util.*;

public class MakeArray2 {

    public int[] solution(int l, int r) {
        if(r < 5) return new int[]{-1};

        List<Integer> result = new ArrayList<>();
        Queue<Integer> que = new ArrayDeque<>();
        que.add(5);

        while(!que.isEmpty()){
            int num = que.poll();

            if(num > r) continue;
            if(num >= l) result.add(num);

            que.add(num * 10);
            que.add(num * 10 + 5);
        }

        return result.isEmpty() ? new int[]{-1}
            : result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int l, int r) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < 64; i++) {
            int num = Integer.parseInt(Integer.toBinaryString(i)) * 5;
            if(num > r) break;
            if(num >= l) list.add(num);
        }

        return list.isEmpty() ? new int[] { -1 } : list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        MakeArray2 task = new MakeArray2();
        int l = 5, r = 555;

        System.out.println(Arrays.toString(task.solution2(l, r)));

        Compare.measureTime(()->task.solution(l, r), ()->task.solution2(l, r));
    }

}
