package programmers.basicTraining.diceGame2;

// 주사위 게임 2

public class DiceGame2 {

    public int solution(int a, int b, int c) {

        if(a == b && b == c){
            return (a + b + c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c);
        }else if(a != b && b != c && a != c){
            return a + b + c;
        }
        return (a + b + c) * (a*a + b*b + c*c);
    }

    public static void main(String[] args) {
        DiceGame2 task = new DiceGame2();
        int a = 5, b = 3, c = 3;

        System.out.println(task.solution(a, b, c));
    }

}
