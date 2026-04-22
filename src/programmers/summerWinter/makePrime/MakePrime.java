package programmers.summerWinter.makePrime;

// 소수 만들기

public class MakePrime {

    public int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length-2; i++){
            for(int j = (i + 1); j < nums.length-1; j++){
                for(int k = (j + 1); k < nums.length; k++){

                    int cur = nums[i] + nums[j] + nums[k];

                    if(isPrime(cur)) answer++;

                }
            }
        }

        return answer;
    }

    private boolean isPrime(int num){

        int len = (int)Math.sqrt(num);

        for(int i = 2; i <= len; i++){
            if(num % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        MakePrime task = new MakePrime();

        int[] nums = {1,2,3,4};

        System.out.println(task.solution(nums));
    }

}
