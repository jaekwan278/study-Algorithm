package programmers.practice.footFightContest;

// 푸드 파이트 대회

public class FoodFightContest {

    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();

        for(int i = 1; i < food.length; i++){

            for(int j = (food[i] / 2); j > 0; j--){
                left.append(i);
            }

        }

        return left + "0" + new StringBuilder(left).reverse();
    }

    public String solution2(int[] food){
        String answer = "0";

        for(int i = (food.length-1); i > 0; i--){

            for(int j = (food[i] / 2); j > 0; j--){
                answer = i + answer + i;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        FoodFightContest task = new FoodFightContest();
        int[] food = {1, 3, 4, 6};

        System.out.println(task.solution2(food));
    }

}
