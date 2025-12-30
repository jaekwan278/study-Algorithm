package programmers.basicTraining.firstNegative;

// 첫번째로 나오는 음수

public class FirstNegative {

    public int solution(int[] num_list) {
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] < 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNegative task = new FirstNegative();
        int[] num_list = {13, 22, 53, 24, 15, 6};

        System.out.println(task.solution(num_list));
    }

}
