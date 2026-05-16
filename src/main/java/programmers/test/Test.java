package programmers.test;

import utils.Compare;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class Test {
    public String solution(String my_string) {
        LinkedHashSet<String> set =
                Arrays.stream(my_string.split(""))
                        .collect(Collectors.toCollection(LinkedHashSet::new));
        return String.join("", set);
    }
    public String solution2(String my_string){
        return my_string.chars()
                .mapToObj(Character::toString)
                .distinct()
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        int[] arr = {};
        int angle = 1;
        String message = "people";
        int n = 7;
        int t = 15;
        String rsp = "a45bcA12BC";
        String[] a = {"a", "b", "c"};
        String[] b = {"com", "b", "d", "p", "c"};

        Test test = new Test();
        Compare compare = new Compare();


        System.out.println(test.solution2(message));
//        System.out.println(Arrays.toString(test.solution(arr, "left")));

//        System.out.println(compare.measureTime(() -> test.solution2(message)));
//        System.out.println(compare.measureTime(() -> test.solution()));
//        System.out.println(compare.measureTime(() -> test.solution2(message)));
//        System.out.println(compare.measureTime(() -> test.solution3(message)));
    }
}

//    평균 구하기
//    public double solution(int[] numbers) {
//        return Arrays.stream(numbers).average().orElse(0);
//    }