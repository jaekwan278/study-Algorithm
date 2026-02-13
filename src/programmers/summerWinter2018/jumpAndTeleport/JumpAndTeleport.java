package programmers.summerWinter2018.jumpAndTeleport;

public class JumpAndTeleport {

    public int solution(int n) {
        int ans = 0;

        while(n > 0){
            if(n % 2 == 1){
                n -= 1;
                ans++;
            }else{
                n /= 2;
            }
        }

        return ans;
    }

    public int solution2(int n){
        System.out.println(Integer.toBinaryString(n));
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        JumpAndTeleport task = new JumpAndTeleport();
        int n = 5000;

        System.out.println(task.solution2(n));
    }

}
