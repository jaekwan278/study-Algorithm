package programmers.practice.subArraySumCount;

// 연속 부분 수열 합의 개수

import java.util.HashSet;
import java.util.Set;

public class SubArraySumCount {

    public int solution(int[] elements) {
        int len = elements.length;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < len; i++){
            int n = 0;
            for(int j = i; j < (len + i); j++){
                n += elements[j % len];
                set.add(n);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        SubArraySumCount task = new SubArraySumCount();
        int[] elements = {7,9,1,1,4};

        System.out.println(task.solution(elements));
    }

}
