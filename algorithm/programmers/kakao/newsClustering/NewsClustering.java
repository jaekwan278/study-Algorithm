package programmers.kakao.newsClustering;

// 뉴스 클러스터링

import utils.Compare;

import java.util.HashMap;
import java.util.Map;

public class NewsClustering {

    // 초기

    public int solution(String str1, String str2) {
        double answer = 0.0;

        Map<String, Integer> mapA = getElements(str1.toUpperCase());
        Map<String, Integer> mapB = getElements(str2.toUpperCase());

        answer = zacard(mapA, mapB);

        return (int)Math.floor(answer * 65536);
    }

    private Map<String, Integer> getElements(String str){

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length()-1; i++){

            char cur = str.charAt(i);
            char next = str.charAt(i+1);

            if(!(cur >= 'A' && cur <= 'Z') || !(next >= 'A' && next <= 'Z')) continue;

            String sub = "" + cur + next;

            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }

        return map;
    }

    private double zacard(Map<String, Integer> A, Map<String, Integer> B){
        double union = 0, its = 0;

        for(Map.Entry<String, Integer> cur : A.entrySet()){

            String key = cur.getKey();
            Integer valA = cur.getValue();
            Integer valB = B.getOrDefault(key, 0);

            union += Math.max(valA, valB);
            its += Math.min(valA, valB);

        }

        for(Map.Entry<String, Integer> cur : B.entrySet()){
            if(!A.containsKey(cur.getKey())){
                union += cur.getValue();
            }
        }

        return (union == 0) ? 1 : (its / union);
    }

    // 개선

    public int solution2(String str1, String str2) {
        int[] A = zacard(str1);
        int[] B = zacard(str2);

        int union = 0, inter = 0;

        for(int i = 0; i < A.length; i++){
            int a = A[i], b = B[i];

            union += Math.max(a, b);
            inter += Math.min(a, b);
        }

        if(union == 0) return 65536;

        return (int)((double)inter / union * 65536);
    }

    private int[] zacard(String str){
        int[] arr = new int[26 * 26];

        for(int i = 0; i < str.length()-1; i++){
            char cur = Character.toUpperCase(str.charAt(i));
            char next = Character.toUpperCase(str.charAt(i+1));

            if(!('A' <= cur && cur <= 'Z') || !('A' <= next && next <= 'Z')) continue;

            arr[((cur - 'A') * 26) + (next - 'A')]++;
        }

        return arr;
    }

    public static void main(String[] args) {
        NewsClustering task = new NewsClustering();

        String str1 = "FRANCE";
        String str2 = "french";

        System.out.println(task.solution2(str1, str2));

        Compare.measureTime(()->task.solution(str1, str2), ()->task.solution2(str1, str2));
    }

}
