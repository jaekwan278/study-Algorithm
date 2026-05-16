package programmers.basicTraining.makeOne;

// 1로 만들기

import utils.Compare;

public class MakeOne {

    public int solution(int[] num_list) {
        int answer = 0;

        for(int num : num_list){
            answer += 31 - Integer.numberOfLeadingZeros(num);
        }

        return answer;
    }

    public int solution2(int[] num_list) {
        int answer = 0;
        for(int i = 0;num_list.length>i;i++){
            while(num_list[i]!=1){
                num_list[i]/=2;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MakeOne task = new MakeOne();
        int[] num_list = {12, 4, 15, 1, 14};

        System.out.println(task.solution(num_list));

        Compare.measureTime(()->task.solution(num_list), ()->task.solution2(num_list));
    }

}
