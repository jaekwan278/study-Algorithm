package programmers.sort.largestNumber;

// 가장 큰 수


import java.util.Arrays;

public class LargestNumber {

    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] nStr = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(nStr, (a, b) -> (b + a).compareTo(a + b));

        for(String str : nStr){
            answer.append(str);
        }

        return (answer.charAt(0) - '0') == 0 ? "0" : answer.toString();
    }

    public static void main(String[] args) {
        LargestNumber task = new LargestNumber();
        int[] numbers = {3, 30, 34, 5, 9, 29};

        System.out.println(task.solution(numbers));

    }

}
