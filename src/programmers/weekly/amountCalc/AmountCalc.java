package programmers.weekly.amountCalc;

// 부족한 금액 계산하기

public class AmountCalc {

    public long solution(int price, int money, int count) {
        long answer = 0;

        for(int i = 0; i < count; i++){
            answer += (long)price * (i+1);
        }

        return money > answer ? 0 : answer - money;
    }

    public long solution2(int price, int money, int count){
        return Math.max((count * (price + price * count) / 2) - money, 0);
    }

    public static void main(String[] args) {
        AmountCalc task = new AmountCalc();
        int price = 3, money = 20, count = 4;

        System.out.println(task.solution2(price, money, count));
    }

}
