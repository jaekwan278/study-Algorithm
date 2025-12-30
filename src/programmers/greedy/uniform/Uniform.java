package programmers.greedy.uniform;

// 체육복

import utils.Compare;

import java.util.Arrays;

public class Uniform {

    public int solution(int n, int[] lost, int[] reserve) {
        int[] uniform = new int[n];
        Arrays.fill(uniform, 1);

        for(int l : lost) uniform[l-1]--;
        for(int r : reserve) uniform[r-1]++;

        for(int i = 0; i < uniform.length; i++){
            if(uniform[i] < 1){
                if(i > 0 && uniform[i-1] > 1){
                    uniform[i]++;
                    uniform[i-1]--;
                }else if(i < uniform.length - 1 && uniform[i+1] > 1){
                    uniform[i]++;
                    uniform[i+1]--;
                }
            }
        }

        return (int)Arrays.stream(uniform)
                .filter(i -> i > 0)
                .count();
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }
        return answer;
    }

    public int solution3(int n, int[] lost, int[] reserve){
        int answer = n;
        int[] uniform = new int[n+2];

        for(int l : lost) uniform[l]--;
        for(int r : reserve) uniform[r]++;

        for(int i = 1; i < uniform.length-1; i++){

            if(uniform[i] < 0){

                if(uniform[i-1] > 0){
                    uniform[i]++;
                    uniform[i-1]--;
                }else if(uniform[i+1] > 0){
                    uniform[i]++;
                    uniform[i+1]--;
                }else{
                    answer--;
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Uniform task = new Uniform();
        int n = 5;
        int[] lost = {2, 4}, reserve = {1, 3, 5};

        System.out.println(task.solution3(n, lost, reserve));

        Compare.measureTime(()->task.solution3(n, lost, reserve), ()->task.solution2(n, lost, reserve));
    }

}
