package programmers.practice.nLCMcalc;

// n개의 최소공배수

public class NLCMCalc {

    public int solution(int[] arr) {
        int answer = arr[0];

        for(int i = 1; i < arr.length; i++){
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    private int gcd(int a, int b){

        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }

    private int lcm(int a, int b){
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        NLCMCalc task = new NLCMCalc();
        int[] arr = {2,6,8,14};

        System.out.println(task.solution(arr));
    }

}
