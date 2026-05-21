package programmers.basicTraining.special2DArray2;

// 특별한 이차원 배열 2

public class Special2DArray2 {

    public int solution(int[][] arr) {
        int len = arr.length;

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(i == j){
                    continue;
                }
                if(arr[i][j] != arr[j][i]){
                    return 0;
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Special2DArray2 task = new Special2DArray2();
        int[][] arr = {{5, 192, 33}, {192, 72, 95}, {33, 95, 999}};

        System.out.println(task.solution(arr));
    }

}
