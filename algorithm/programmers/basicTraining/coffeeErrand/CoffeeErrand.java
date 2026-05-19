package programmers.basicTraining.coffeeErrand;

// 커피 심부름

public class CoffeeErrand {

    public int solution(String[] order) {
        int answer = 0;

        for(String str : order){
            if(str.contains("cafelatte")) answer += 5000;
            else answer+= 4500;
        }

        return answer;
    }

    public static void main(String[] args) {
        CoffeeErrand task = new CoffeeErrand();
        String[] order = {"cafelatte", "americanoice", "hotcafelatte", "anything"};

        System.out.println(task.solution(order));
    }

}
