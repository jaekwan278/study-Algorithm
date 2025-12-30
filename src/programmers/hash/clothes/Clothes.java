package programmers.hash.clothes;

// 의상

import java.util.HashMap;

public class Clothes {

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for(String[] strArr : clothes){
            map.put(strArr[1], map.getOrDefault(strArr[1], 0) + 1);
        }

        for(Integer cnt : map.values()){
            answer *= (cnt + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        Clothes task = new Clothes();
        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(task.solution(clothes));
    }

}
