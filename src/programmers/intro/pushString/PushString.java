package programmers.intro.pushString;

// 문자열 밀기

// 문자열 "hello"에서 각 문자를 오른쪽으로 한 칸씩 밀고 마지막 문자는 맨 앞으로 이동시키면 "ohell"이 됩니다.
// 이것을 문자열을 민다고 정의한다면 문자열 A와 B가 매개변수로 주어질 때,
// A를 밀어서 B가 될 수 있다면 밀어야 하는 최소 횟수를 return하고 밀어서 B가 될 수 없으면 -1을 return 하도록 solution 함수를 완성해보세요.

// 0 < A의 길이 = B의 길이 < 100
// A, B는 알파벳 소문자로 이루어져 있습니다.

import utils.Compare;

import java.util.ArrayDeque;
import java.util.Deque;

public class PushString {

    public int solution(String A, String B) {
        int answer = -1;

        Deque<Character> que = new ArrayDeque<>();
        for(char c : A.toCharArray()){
            que.addLast(c);
        }

        for(int i = 0; i < A.length(); i++){
            StringBuilder sb = new StringBuilder();
            for(char ch : que) sb.append(ch);
            if(sb.toString().equals(B)) return i;
            que.addFirst(que.pollLast());
        }

        return answer;
    }

    public int solution2(String A, String B){
        int answer = -1;
        int size = A.length() - 1;

        StringBuilder sb = new StringBuilder(A);

        for(int i = 0; i < A.length(); i++){
            if(sb.toString().equals(B)) return i;

            char ch = sb.charAt(size);
            sb.deleteCharAt(size);
            sb.insert(0, ch);
        }

        return answer;
    }

    public int solution3(String A, String B) {
        String tempB = B.repeat(3);
        return tempB.indexOf(A);
    }

    public static void main(String[] args) {
        PushString task = new PushString();
        String A = "apple";
        String B = "elppa";

        System.out.println(task.solution2(A, B));

        Compare.measureTime(() -> task.solution(A, B), () -> task.solution2(A, B));
    }

}
