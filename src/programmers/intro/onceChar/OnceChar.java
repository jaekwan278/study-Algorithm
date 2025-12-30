package programmers.intro.onceChar;


// 문자열 s가 매개변수로 주어집니다. s에서 한 번만 등장하는 문자를 사전 순으로
// 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요. 한 번만 등장하는 문
// 자가 없을 경우 빈 문자열을 return 합니다.


import java.util.Arrays;

public class OnceChar {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            int cnt = 0;
            for(char c2 : s.toCharArray()){
                if(c == c2){
                    cnt++;
                }
            }
            if(cnt > 1){
                continue;
            }
            sb.append(c);
        }

        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);

        return new String(arr);
    }

    public static void main(String[] args) {
        OnceChar task = new OnceChar();

        System.out.println(task.solution("abdc"));
    }

}
