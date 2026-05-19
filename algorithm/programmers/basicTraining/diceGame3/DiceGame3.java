package programmers.basicTraining.diceGame3;

// 주사위 게임 3

import utils.Compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiceGame3 {

    public int solution(int a, int b, int c, int d) {
        int[] dice = new int[7];
        dice[a]++; dice[b]++; dice[c]++; dice[d]++;

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 6; i++){
            if(dice[i] != 0) list.add(i);
        }

        int size = list.size();

        if(size == 4){
            return list.get(0);
        }else if(size == 3){
            return list.stream()
                    .filter(e -> dice[e] == 1)
                    .reduce(1, (n, m) -> n * m);
        }else if(size == 2){
            if(dice[list.get(0)] == 2){
                return (list.get(0) + list.get(1)) * Math.abs(list.get(0) - list.get(1));
            }else{
                int p = 0, q = 0;

                if(dice[list.get(0)] == 3){
                    p = list.get(0);
                    q = list.get(1);
                }else{
                    p = list.get(1);
                    q = list.get(0);
                }

                return (int)Math.pow(10 * p + q, 2);
            }
        }

        return list.get(0) * 1111;
    }

    public int solution2(int a, int b, int c, int d) {
        int[] dice = {a, b, c, d};
        Arrays.sort(dice);

        //  전부 같음
        if(dice[0] == dice[3]){
            return 1111 * dice[0];
        }
        // 3개 같음 (앞)
        else if(dice[0] == dice[2]){
            return (int)Math.pow(10 * dice[0] + dice[3], 2);
        }
        // 3개 같음 (뒤)
        else if(dice[1] == dice[3]){
            return (int)Math.pow(10 * dice[3] + dice[0], 2);
        }
        // 2개 쌍이 같음
        else if(dice[0] == dice[1] && dice[2] == dice[3]){
            return (dice[0] + dice[3]) * Math.abs(dice[0] - dice[3]);
        }
        // 2개만 같음
        else if(dice[0] == dice[1]){
            return dice[2] * dice[3];
        }
        // 2개만 같음
        else if(dice[1] == dice[2]){
            return dice[0] * dice[3];
        }
        // 2개만 같음
        else if(dice[2] == dice[3]){
            return dice[0] * dice[1];
        }
        // 전부 다름
        return dice[0];
    }

    public static void main(String[] args) {
        DiceGame3 task = new DiceGame3();

//        int a = 2, b = 2, c = 2, d = 2;
//        int a = 2, b = 5, c = 2, d = 6;
        int a = 6, b = 3, c = 3, d = 6;

        System.out.println(task.solution2(a, b, c, d));

        Compare.measureTime(()->task.solution(a, b, c, d), ()->task.solution2(a, b, c, d));
    }
}
