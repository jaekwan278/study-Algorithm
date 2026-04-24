package programmers.practice.divideString;

// 문자열 나누기

public class DivideString {

    public int solution(String s) {
        int answer = 0;

        int same = 0;
        int diff = 0;

        char cur = s.charAt(0);

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == cur) same++;
            else diff++;

            if(same == diff){
                answer++;
                same = 0;
                diff = 0;

                if(i + 1 < s.length()){
                    cur = s.charAt(i+1);
                }
            }
        }

        return (same != 0 || diff != 0) ? answer + 1 : answer;
    }

    public static void main(String[] args) {
        DivideString task = new DivideString();

//        String s = "banana";
//        String s = "abracadabra";
        String s = "aaabbaccccabba";

        System.out.println(task.solution(s));
    }

}
