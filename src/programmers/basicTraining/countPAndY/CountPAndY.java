package programmers.basicTraining.countPAndY;

// 문자열 내 p와 y의 개수

import utils.Compare;

public class CountPAndY {

    boolean solution(String s) {
        String str = s.toLowerCase();
        int a = str.length() - str.replaceAll("p", "").length();
        int b = str.length() - str.replaceAll("y", "").length();

        return a == b;
    }

    boolean solution2(String s) {
        s = s.toUpperCase();

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }

    public static void main(String[] args) {
        CountPAndY task = new CountPAndY();
        String s = "Pyy";

//        System.out.println(task.solution(s));

        Compare.measureTime(()->task.solution(s), ()->task.solution2(s));
    }

}
