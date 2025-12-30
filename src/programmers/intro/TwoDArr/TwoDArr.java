package programmers.intro.TwoDArr;

public class TwoDArr {

    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];

        for(int i = 0; i < answer.length; i++){
            System.arraycopy(num_list, i*n, answer[i], 0, n);
        }

        return answer;
    }

    public static void main(String[] args) {
        TwoDArr twoDArr = new TwoDArr();

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};

        int[][] result = twoDArr.solution(nums, 2);

        for(int[] a : result){
            for(int b : a){
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
