package programmers.practice.overPaint;

// 덧칠하기

public class OverPaint {

    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int idx = 0;
        for(int sec : section){
            if(idx < sec){
                idx = sec + (m - 1);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        OverPaint task = new OverPaint();

        int n = 8, m = 4;
        int[] section = {2, 3, 6};

        System.out.println(task.solution(n, m, section));
    }

}
