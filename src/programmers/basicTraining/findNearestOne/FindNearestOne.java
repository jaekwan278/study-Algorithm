package programmers.basicTraining.findNearestOne;

// 가까운 1 찾기

public class FindNearestOne {

    public int solution(int[] arr, int idx) {
        for(int i = idx; i < arr.length; i++){
            if(arr[i] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindNearestOne task = new FindNearestOne();
        int[] arr = {1, 1, 1, 1, 0};
        int idx = 3;

        System.out.println(task.solution(arr, idx));
    }

}
