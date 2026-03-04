package programmers.kakao2019.tuple;

import java.util.*;

public class Tuple {

    public int[] solution(String s) {

        String str = s.replaceAll("[{}]", "");
        String[] strArr = str.split(",");

        Map<Integer, Integer> map = new HashMap<>();
        for(String numStr : strArr){
            int num = Integer.parseInt(numStr);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        return list.stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public int[] solution2(String s) {

        String[] strArr = s.replaceAll("[{}]", "").split(",");

        Map<Integer, Integer> map = new HashMap<>();
        for(String str : strArr){
            int cur = Integer.parseInt(str);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        return map.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static void main(String[] args) {
        Tuple task = new Tuple();

        String s = "{{20,111},{111}}";

        System.out.println(Arrays.toString(task.solution2(s)));
    }

}
