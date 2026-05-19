package programmers.basicTraining.diceGame1;

// 주사위 게임 1

public class DiceGame1 {
    public int solution(int a, int b) {
        int answer = 0;

        if((a+b) % 2 == 0){
            if(a % 2 == 0){
                answer = Math.abs(a - b);
            }else{
                answer = (int)(Math.pow(a, 2) + Math.pow(b, 2));
            }
        }else{
            answer = 2 * (a + b);
        }

        return answer;
    }

    public static void main(String[] args) {
        DiceGame1 task = new DiceGame1();
        int a = 3, b = 5;

        System.out.println(task.solution(a, b));
    }
}
