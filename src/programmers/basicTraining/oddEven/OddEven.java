package programmers.basicTraining.oddEven;

// 홀수 짝수

public class OddEven {

    public int solution(int[] num_list) {
        int odd = 0;
        int even = 0;

        for(int i = 0; i < num_list.length; i++){
            if(i % 2 == 0){
                odd += num_list[i];
            }else{
                even += num_list[i];
            }
        }

        return Math.max(odd, even);
    }

    public static void main(String[] args) {
        OddEven task = new OddEven();
        int[] num_list = {4, 2, 6, 1, 7, 6};

        System.out.println(task.solution(num_list));
    }

}
