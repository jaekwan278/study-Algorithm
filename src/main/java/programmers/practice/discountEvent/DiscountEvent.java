package programmers.practice.discountEvent;

// 할인 행사

import utils.Compare;

import java.util.HashMap;
import java.util.Map;

public class DiscountEvent {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wishList = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            wishList.put(want[i], number[i]);
        }

        int len = discount.length;
        for(int i = 0; i <= len - 10; i++){
            Map<String, Integer> copy = new HashMap<>(wishList);
            boolean isOk = true;

            for(int j = 0; j < 10; j++){
                String key = discount[i+j];

                if(!copy.containsKey(key)){
                    isOk = false;
                    break;
                }else{
                    int cnt = copy.get(key);

                    if(cnt == 0){
                        isOk = false;
                        break;
                    }

                    copy.replace(key, copy.get(key) - 1);
                }
            }

            if(isOk) answer++;

        }

        return answer;
    }

    public int solution2(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wishList = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            wishList.put(want[i], number[i]);
        }

        Map<String, Integer> window = new HashMap<>();
        for(int i = 0; i < 10; i++){
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
        }

        for(int i = 10; i < discount.length; i++){
            if(wishList.equals(window)) answer++;

            String remove = discount[i-10];
            window.put(remove, window.get(remove) - 1);

            if(window.get(remove) == 0) window.remove(remove);

            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
        }

        if(wishList.equals(window)) answer++;

        return answer;
    }

    public static void main(String[] args) {
        DiscountEvent task = new DiscountEvent();

        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(task.solution2(want, number, discount));

        Compare.measureTime(()->task.solution(want, number, discount), ()->task.solution2(want, number, discount));
    }
}
