package programmers.kakao.cache;

// [1차]캐시

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Cache {

    // 초기
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0){
            return cities.length * 5;
        }

        LinkedList<String> list = new LinkedList<>();

        for(String c : cities){

            String cur = c.toUpperCase();

            if(list.contains(cur)){
                answer += 1;
                list.addLast(list.remove(list.indexOf(cur)));
            }else{

                if(list.size() >= cacheSize){
                    list.remove(0);
                    list.addLast(cur);
                }else{
                    list.addLast(cur);
                }

                answer += 5;
            }

        }

        return answer;
    }

    // 최적 LRU -> LinkedHashMap
    public int solution2(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;

        int answer = 0;

        LinkedHashMap<String, Boolean> cache =
                new LinkedHashMap<>(cacheSize, 1.0f, true){
                    @Override
                    protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                        return size() > cacheSize;
                    }
                };

        for(String c : cities){

            String cur = c.toUpperCase();

            if(cache.put(cur, true) != null){
                answer += 1;
            }else{
                answer += 5;
            }

        }

        return answer;
    }



    public static void main(String[] args) {
        Cache task = new Cache();
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(task.solution2(cacheSize, cities));
    }

}
