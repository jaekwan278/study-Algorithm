package programmers.basicTraining.splitAndSort;

// 문자열 잘라서 정렬하기

import utils.Compare;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitAndSort {

    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        Arrays.sort(answer);

        List<String> filter = Arrays.stream(answer)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());

        return filter.toArray(new String[0]);
    }

    public String[] solution2(String myString){
        return Arrays.stream(myString.split("x")).filter(str -> !str.isEmpty()).sorted().toArray(String[]::new);
    }


    public static void main(String[] args) {
        SplitAndSort task = new SplitAndSort();
        String myString = "dxccxbbbxaaaa";

        System.out.println(Arrays.toString(task.solution2(myString)));

        Compare.measureTime(()->task.solution(myString), ()->task.solution2(myString));
    }

}
