package programmers.practice.cuttingRollCake;

// 롤 케이크 자르기

import utils.Compare;

import java.util.HashMap;
import java.util.HashSet;

public class CuttingRollCake {

    public int solution(int[] topping) {
        int answer = 0;

        HashMap<Integer, Integer> ob = new HashMap<>();
        HashSet<Integer> yb = new HashSet<>();

        for(int t : topping){
            ob.put(t, ob.getOrDefault(t, 0) + 1);
        }

        for(int cur : topping){

            if(yb.size() == ob.size()) answer++;

            yb.add(cur);

            int cnt = ob.getOrDefault(cur, 0) - 1;

            if(cnt == 0) ob.remove(cur);
            else ob.put(cur, cnt);
        }

        return answer;
    }

    public int solution2(int[] topping) {
        int answer = 0;

        int[] ob = new int[topping.length];
        int[] yb = new int[topping.length];

        int obCnt = 0, ybCnt = 0;

        for(int t : topping) ob[t]++;
        for(int t : ob) if(t > 0) obCnt++;

        for(int t : topping){
            if(--ob[t] == 0) obCnt--;
            if(yb[t]++ == 0) ybCnt++;

            if(obCnt == ybCnt) answer++;
        }

        return answer;
    }


    public static void main(String[] args) {
        CuttingRollCake task = new CuttingRollCake();

        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};

        System.out.println(task.solution2(topping));

        Compare.measureTime(()->task.solution(topping), ()->task.solution2(topping));
    }

}
