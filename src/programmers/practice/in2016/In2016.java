package programmers.practice.in2016;

// 2016년

import utils.Compare;

import java.time.LocalDate;

public class In2016 {

    public String solution(int a, int b) {

        LocalDate date = LocalDate.of(2016, a, b);

        return date
                .getDayOfWeek()
                .toString()
                .substring(0, 3);
    }

    private static final String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    private static final int[] monthCnt = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String solution2(int a, int b) {

        int answer = 0;

        for(int i = 0; i < (a - 1); i++){
            answer += monthCnt[i];
        }

        answer += b - 1;

        return week[answer % 7];
    }

    public static void main(String[] args) {
        In2016 task = new In2016();
        int a = 5, b = 24;

        System.out.println(task.solution2(a, b));

        Compare.measureTime(()->task.solution(a, b), ()->task.solution2(a, b));
    }

}
