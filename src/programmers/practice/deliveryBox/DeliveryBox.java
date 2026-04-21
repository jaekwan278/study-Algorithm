package programmers.practice.deliveryBox;

// 택배 상자

import utils.Compare;

import java.util.ArrayDeque;

public class DeliveryBox {

    public int solution(int[] order) {
        int answer = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int idx = 1;
        for(int cur : order){

            while(idx <= order.length && idx < cur){
                stack.push(idx++);
            }

            if(cur == idx){
                answer++;
                idx++;
            }else if(!stack.isEmpty() && stack.peek() == cur){
                answer++;
                stack.pop();
            }else{
                break;
            }
        }

        return answer;
    }

    public int solution2(int[] order) {
        int idx = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < order.length; i++){
            stack.push(i+1);
            while(!stack.isEmpty()){
                if (stack.peek() == order[idx]){
                    stack.pop();
                    idx++;
                } else break;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        DeliveryBox task = new DeliveryBox();

        int[] order = {4, 3, 1, 2, 5};

        System.out.println(task.solution(order));

        Compare.measureTime(()->task.solution(order), ()->task.solution2(order));
    }

}
