package programmers.greedy.lifeBoat;

// 구명보트

import utils.Compare;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LifeBoat {

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int[] seat = new int[]{0, people.length - 1};
        while(seat[0] <= seat[1]){

            if(people[seat[0]] + people[seat[1]] <= limit){
                seat[0]++;
            }

            seat[1]--;
            answer++;
        }


        return answer;
    }

    public int solution2(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }

    // [0, 2]

    public static void main(String[] args) {
        LifeBoat task = new LifeBoat();
        int[] people = {30, 30, 30};
        int limit = 80;

        System.out.println(task.solution(people, limit));

        Compare.measureTime(()->task.solution(people, limit), ()->task.solution2(people, limit));
    }

}
