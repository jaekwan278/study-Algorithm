package programmers.basicTraining.compareProductAndSum;

// 원소들의 곱과 합

import utils.Compare;

public class CompareProductAndSum {

    public int solution(int[] num_list) {
        int product = 1;
        for(int num : num_list){
            product *= num;
        }
        int sum = 0;
        for(int num : num_list){
            sum += num;
        }
        sum *= sum;

        return (product > sum) ? 0 : 1;
    }

    public int solution2(int[] num_list){
        int product = 1, sum = 0;

        for(int num : num_list){
            product *= num;
            sum += num;
        }

        return (Math.pow(sum, 2) > product) ? 1 : 0;
    }

    public static void main(String[] args) {
        CompareProductAndSum task = new CompareProductAndSum();
        int[] num_list = {3, 4, 5, 2, 1};

        System.out.println(task.solution2(num_list));

        Compare.measureTime(()->task.solution(num_list), ()->task.solution2(num_list));
    }

}
