package programmers.test;

public class Test02 {

    public int solution(String t, String p) {
        int answer = 0;

        for(int i = 0; i <= t.length() - p.length(); i++){
            String sub = t.substring(i, i + p.length());

            if(sub.compareTo(p) <= 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Test02 task = new Test02();

        String t = "10203", p = "15";

        System.out.println(task.solution(t, p));
    }
}
