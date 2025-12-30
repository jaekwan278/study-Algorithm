package programmers.intro.babbling;

import utils.Compare;

public class Test {
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        Babbling test = new Babbling();
        Ref01 ref = new Ref01();

        Compare compare = new Compare();

//        long testTime = compare.measureTime(() -> System.out.println(test.solution(babbling)));
//        long refTime = compare.measureTime(() -> System.out.println(ref.solution(babbling)));

//        System.out.println("test : " + testTime);
//        System.out.println("ref : " + refTime);

    }
}
