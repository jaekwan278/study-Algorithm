package programmers.sort.h_index;

// H-Index

import utils.Compare;

import java.util.Arrays;
import java.util.TreeSet;

public class H_Index {

    public int solution(int[] citations) {
        int answer = 0;

        TreeSet<Integer> tSet = new TreeSet<>();
        for(int c : citations) tSet.add(c);

        int len = tSet.size();
        for(int i = 0; i < len; i++){
            Integer cur = tSet.pollLast();
            if(cur == null) break;
            if(cur >= (i + 1)) answer = cur;
        }

        return answer;
    }

    public int solution2(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int len = citations.length;
        for(int i = 0; i < len; i++){
            int h = i + 1;

            if(citations[len - h] >= h){
                answer = h;
            }else{
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        H_Index task = new H_Index();
        int[] citations = {5, 5, 5, 5};

        System.out.println(task.solution2(citations));

        Compare.measureTime(()->task.solution(citations), ()->task.solution2(citations));
    }

}

/*

    { 0, 1, 3, 5, 6 }

 */
