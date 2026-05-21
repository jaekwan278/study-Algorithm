package programmers.practice.customStringSorting;

// 문자열 마음대로 정렬하기

import utils.Compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CustomStringSorting {

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            char ac = a.charAt(n), bc = b.charAt(n);

            if(ac == bc) return a.compareTo(b);

            return ac - bc;
        });

        return strings;
    }

    public String[] solution2(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
    }

    public static void main(String[] args) {
        CustomStringSorting task = new CustomStringSorting();
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

        System.out.println(Arrays.toString(task.solution(strings, n)));

        Compare.measureTime(()->task.solution(strings, n), ()->task.solution2(strings, n));
    }

}
