package programmers.heap.doublePriorityQue;

// 이중 우선 큐

import utils.Compare;

import java.util.*;

public class DoublePriorityQue {

    public void removeNode(TreeMap<Integer, Integer> tMap, int key){
        int value = tMap.get(key);
        if(value > 1){
            tMap.put(key, value - 1);
        }else{
            tMap.remove(key);
        }
    }

    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();


        for(int i = 0; i < operations.length; i++){
            String[] next = operations[i].split(" ");

            if(tMap.isEmpty() && next[0].equals("D")){
                continue;
            }

            int key = Integer.parseInt(next[1]);

            if(next[0].equals("I")){
                tMap.put(key, tMap.getOrDefault(key, 0) + 1);
            }else{
                if(key < 0){
                    removeNode(tMap, tMap.firstKey());
                }else{
                    removeNode(tMap, tMap.lastKey());
                }
            }
        }

        return !tMap.isEmpty() ? new int[] { tMap.lastKey(), tMap.firstKey() } : new int[2];
    }

    public int[] solution2(String[] operations) {
        Queue<Integer> minpq = new PriorityQueue<>();
        Queue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            if (operation.startsWith("I ")) {
                int n = Integer.parseInt(operation.substring(2));
                minpq.offer(n);
                maxpq.offer(n);
            } else if (!minpq.isEmpty() && operation.equals("D -1")) {
                maxpq.remove(minpq.poll());
            } else if (!maxpq.isEmpty() && operation.equals("D 1")) {
                minpq.remove(maxpq.poll());
            }
        }

        if (minpq.isEmpty() && maxpq.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{maxpq.poll(), minpq.poll()};
    }

    public static void main(String[] args) {
        DoublePriorityQue task = new DoublePriorityQue();
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        System.out.println(Arrays.toString(task.solution(operations)));

        Compare.measureTime(()->task.solution(operations), ()->task.solution2(operations));
    }

}
