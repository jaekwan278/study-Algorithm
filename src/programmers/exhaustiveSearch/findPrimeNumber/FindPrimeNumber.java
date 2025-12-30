package programmers.exhaustiveSearch.findPrimeNumber;

// 소수 찾기

/*
    - String to Int Array
    -> char stream

    - 모든 경우의 수 조합
    -> dfs(int[] nums, boolean[] visited, List<Integer> path, Set<List<Integer>> result)
    - 중복 제거
    -> Set<List<Integer>>

    - 소수 판별

    - 소수 카운트
 */

import java.util.*;

public class FindPrimeNumber {

    static Set<List<Integer>> result = new HashSet<>();
    static boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        int[] nums = numbers.chars().map(n -> n - '0').toArray();

        dfs(nums, visited, new ArrayList<>(), result);

        int[] unique = result.stream()
                .map(ls -> ls.stream().reduce(0, (acc, n) -> acc * 10 + n))
                .distinct()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();

        for(int num : unique){
            if(isPrime(num)) answer++;
        }

        return answer;
    }

    private static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }


    private static void dfs(int[] nums, boolean[] visited, List<Integer> path, Set<List<Integer>> result){
        if(!path.isEmpty()){
            result.add(new ArrayList<>(path));
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;

            dfs(nums, visited, path, result);

            path.remove(path.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        FindPrimeNumber task = new FindPrimeNumber();
        String numbers = "17";

        System.out.println(task.solution(numbers));
    }

}
