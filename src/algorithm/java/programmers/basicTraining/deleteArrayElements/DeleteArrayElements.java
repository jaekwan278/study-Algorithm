package programmers.basicTraining.deleteArrayElements;

import utils.Compare;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeleteArrayElements {

    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> deleteSet = Arrays.stream(delete_list).boxed().collect(Collectors.toSet());

        return Arrays.stream(arr)
                .filter(n -> !deleteSet.contains(n))
                .toArray();
    }

    public int[] solution2(int[] arr, int[] delete_list) {
        return IntStream.of(arr).filter(i -> !IntStream.of(delete_list).anyMatch(s -> s == i)).toArray();
    }

    public static void main(String[] args) {
        DeleteArrayElements task = new DeleteArrayElements();

        int[] arr = {293, 1000, 395, 678, 94};
        int[] delete_list = {94, 777, 104, 1000, 1, 12};

        System.out.println(Arrays.toString(task.solution(arr, delete_list)));

        Compare.measureTime(()->task.solution(arr, delete_list), ()->task.solution2(arr, delete_list));
    }
}
