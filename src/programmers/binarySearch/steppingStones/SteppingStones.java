package programmers.binarySearch.steppingStones;

// 징검다리

/*

    거리가 짧은 바위 우선 제거 ?
        sort -> 0, [2, 11, 14, 17, 21], 25
        distance[] -> [2, 9, 3, 3, 4, 4]

 */

import com.sun.source.tree.Tree;

import java.util.*;

public class SteppingStones {

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        if(n == rocks.length) return distance;

        Arrays.sort(rocks);
        int[] tmp = Arrays.copyOfRange(rocks, 0, rocks.length+1);
        tmp[tmp.length-1] = distance;

        System.out.println(Arrays.toString(tmp));
        HashMap<Integer, Integer> map = new HashMap<>();

        int min = 0;
        for(int i = 0; i < tmp.length; i++){
            map.put(i, tmp[i] - min);
            min = tmp[i];
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e1.getValue() - e2.getValue());

        for(int i = 0; i < n; i++){
            map.get(0);
        }

        return answer;
    }

    private int binarySearch(int distance, int n, int[] rocks){
        int min = 0;
        int max = distance;

        while(min <= max){
            int mid = (min + max) / 2;


        }

        return 0;
    }


    public static void main(String[] args) {
        SteppingStones task = new SteppingStones();

        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;

        System.out.println(task.solution(distance, rocks, n));
    }
}
