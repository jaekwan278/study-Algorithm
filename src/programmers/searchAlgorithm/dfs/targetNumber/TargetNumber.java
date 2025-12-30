package programmers.searchAlgorithm.dfs.targetNumber;

// 타겟 넘버
/*

    0.

 */

public class TargetNumber {

    public int solution(int[] numbers, int target) {

        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int idx, int sum){
        int result = 0;

        if(idx == numbers.length){
            return sum == target ? 1 : 0;
        }

        result += dfs(numbers, target, idx+1, sum + numbers[idx]);
        result += dfs(numbers, target, idx+1, sum - numbers[idx]);

        return result;
    }

    public static void main(String[] args) {
        TargetNumber task = new TargetNumber();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(task.solution(numbers, target));
    }

}
