package programmers.practice.chooseTangerines;

// 귤 고르기

import utils.Compare;

import java.util.*;

public class ChooseTangerines {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pQue = new PriorityQueue<>(
                Map.Entry.<Integer, Integer>comparingByValue().reversed()
        );

        pQue.addAll(map.entrySet());

        int sum = 0;
        while(sum < k && !pQue.isEmpty()){
            sum += pQue.poll().getValue();
            answer++;
        }

        return answer;
    }

    public int solution2(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map =new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2)-map.get(o1));

        for(Integer key:list){
            k -=map.get(key);
            answer++;
            if(k<=0){
                break;
            }
        }

        return answer;
    }

    public int solution3(int k, int[] tangerine){
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort((a, b) -> b - a);

        int sum = 0;
        for(int n : list){
            sum += n;
            answer++;

            if(sum >= k) break;
        }

        return answer;
    }


    public static void main(String[] args) {
        ChooseTangerines task = new ChooseTangerines();
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(task.solution3(k, tangerine));

        Compare.measureTime(()->task.solution2(k, tangerine), ()->task.solution3(k, tangerine));
    }

}
