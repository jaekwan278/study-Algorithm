package programmers.stackQue.truckCrossBridge;

// 다리를 지나는 트럭

import utils.Compare;

import java.util.*;

public class TruckCrossBridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int curWeight = 0;
        int curLength = 1;

        Queue<Integer> bridge = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++) bridge.add(0);

        int pointer = 0;
        while(pointer < truck_weights.length){

            int passed = bridge.poll();
            curWeight -= passed;
            curLength--;

            if(truck_weights[pointer] + curWeight <= weight && (curLength + 1) <= bridge_length){
                bridge.add(truck_weights[pointer]);
                curWeight += truck_weights[pointer];
                curLength++;
                pointer++;
            }else{
                bridge.add(0);
            }

            answer++;
        }

        return answer + bridge.size();
    }

    public int solution2(int bridge_length, int weight, int[] truck_weights) {
        Stack<Integer> truckStack = new Stack<>();
        Map<Integer, Integer> bridgeMap = new HashMap<>();

        for (int i = truck_weights.length-1; i >= 0; i--)
            truckStack.push(truck_weights[i]);

        int answer = 0;
        int sum = 0;
        while(true) {
            answer++;

            if (bridgeMap.containsKey(answer))
                bridgeMap.remove(answer);

            sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();

            if (!truckStack.isEmpty())
                if (sum + truckStack.peek() <= weight)
                    bridgeMap.put(answer + bridge_length, truckStack.pop());

            if (bridgeMap.isEmpty() && truckStack.isEmpty())
                break;


        }
        return answer;
    }

    public static void main(String[] args) {
        TruckCrossBridge task = new TruckCrossBridge();
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(task.solution(bridge_length, weight, truck_weights));

        Compare.measureTime(()->task.solution(bridge_length, weight, truck_weights), ()->task.solution2(bridge_length, weight, truck_weights));
    }

}
