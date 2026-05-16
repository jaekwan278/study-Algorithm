package programmers.basicTraining.joinString;

// 문자열 묶기

import utils.Compare;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JoinString {

    public int solution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(String str : strArr){
            map.put(str.length(), map.getOrDefault(str.length(), 0) + 1);
        }

        return Collections.max(map.values());
    }

    public int solution2(String[] strArr){
        int[] answer = new int[31];

        for(String str : strArr){
            answer[str.length()]++;
        }

        int max = 0;
        for(int n : answer){
            if(n > max){
                max = n;
            }
        }

        return max;
    }

    public int solution3(String[] strArr){
        int[] arr = new int[31];
        int answer = 0;

        for(String str : strArr){
            answer = Math.max(++arr[str.length()], answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        JoinString task = new JoinString();
        String[] strArr = {"a","bc","d","efg","hi"};

        System.out.println(task.solution3(strArr));

        Compare.measureTime(()->task.solution2(strArr), ()->task.solution3(strArr));
    }

}
