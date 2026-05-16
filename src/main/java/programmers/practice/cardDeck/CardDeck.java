package programmers.practice.cardDeck;

// 카드 뭉치

import utils.Compare;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CardDeck {

    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Deque<String> deque = new ArrayDeque<>(Arrays.asList(goal));

        int cnt1 = 0, cnt2 = 0;

        while(!deque.isEmpty()){

            String cur = deque.peek();

            if(cnt1 < cards1.length && cards1[cnt1].equals(cur)){
                cnt1++;
                deque.poll();
            }else if(cnt2 < cards2.length && cards2[cnt2].equals(cur)){
                cnt2++;
                deque.poll();
            }else{
                break;
            }

        }

        return deque.isEmpty() ? "Yes" : "No";
    }

    public String solution2(String[] cards1, String[] cards2, String[] goal) {

        int i = 0, j = 0;

        for(String g : goal){

            if(i < cards1.length && cards1[i].equals(g)){
                i++;
            }else if(j < cards2.length && cards2[j].equals(g)){
                j++;
            }else{
                return "No";
            }

        }

        return "Yes";
    }

    public static void main(String[] args) {
        CardDeck task = new CardDeck();

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(task.solution2(cards1, cards2, goal));

        Compare.measureTime(()->task.solution(cards1, cards2, goal), ()->task.solution2(cards1, cards2, goal));
    }

}
