package programmers.intro.chickenCoupon;

// 치킨 쿠폰

// 프로그래머스 치킨은 치킨을 시켜먹으면 한 마리당 쿠폰을 한 장 발급합니다.
// 쿠폰을 열 장 모으면 치킨을 한 마리 서비스로 받을 수 있고, 서비스 치킨에도 쿠폰이 발급됩니다.
// 시켜먹은 치킨의 수 chicken이 매개변수로 주어질 때 받을 수 있는 최대 서비스 치킨의 수를 return하도록 solution 함수를 완성해주세요.

// chicken은 정수입니다.
// 0 ≤ chicken ≤ 1,000,000

public class ChickenCoupon {

    public int solution(int chicken) {
        return calcService(chicken, 0);
    }

    public int calcService(int remain, int result){
        if(remain < 10){
            return result;
        }
        int coupon = remain / 10;
        return calcService(((remain % 10) + coupon) ,(result + coupon));
    }


    public int solution2(int chicken){
        int service = 0;
        int coupon = chicken;

        while(coupon >= 10){
            int newChicken = coupon / 10;
            service += newChicken;
            coupon = coupon % 10 + newChicken; // 남은 쿠폰 + 새로 생긴 쿠폰
        }

        return service;
    }

    public static void main(String[] args) {
        ChickenCoupon task = new ChickenCoupon();
        int chicken = 1081;

        System.out.println(task.solution2(chicken));
    }

}
