package programmers.basicTraining.compareDate;

// 날짜 비교하기

public class CompareDate {

    public int solution(int[] date1, int[] date2) {
        int a = Integer.parseInt(String.format("%04d%02d%02d", date1[0], date1[1], date1[2]));
        int b = Integer.parseInt(String.format("%04d%02d%02d", date2[0], date2[1], date2[2]));

        return (a < b) ? 1 : 0;
    }

}
