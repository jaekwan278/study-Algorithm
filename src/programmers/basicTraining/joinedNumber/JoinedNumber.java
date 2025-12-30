package programmers.basicTraining.joinedNumber;

// 이어 붙인 수

import utils.Compare;

public class JoinedNumber {

    public int solution(int[] num_list) {

        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for(int num : num_list){
            if(num % 2 == 0){
                even.append(num);
            }else{
                odd.append(num);
            }
        }

        return Integer.parseInt(even.toString()) + Integer.parseInt(odd.toString());
    }

    public int solution2(int[] num_list){
        StringBuilder[] sb = {new StringBuilder(), new StringBuilder()};

        for(int num : num_list){
            sb[num % 2].append(num);
        }

        return Integer.parseInt(sb[0].toString()) + Integer.parseInt(sb[1].toString());

    }

    public static void main(String[] args) {
        JoinedNumber task = new JoinedNumber();
        int[] num_list = {3, 4, 5, 2, 1};

        System.out.println(task.solution(num_list));

        Compare.measureTime(()->task.solution(num_list), ()->task.solution2(num_list));
    }

}
