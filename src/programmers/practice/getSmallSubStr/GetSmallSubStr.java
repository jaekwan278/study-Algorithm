package programmers.practice.getSmallSubStr;

// 크기가 작은 부분문자열

public class GetSmallSubStr {

    public int solution(String t, String p) {
        int answer = 0;
        long pNum = Long.parseLong(p);

        for(int i = 0; i <= t.length() - p.length(); i++){
            String sbStr = t.substring(i, i + p.length());
            long cNum = Long.parseLong(sbStr);

            if(cNum <= pNum) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        GetSmallSubStr task = new GetSmallSubStr();

        System.out.println(task.solution("10203", "15"));
    }

}
