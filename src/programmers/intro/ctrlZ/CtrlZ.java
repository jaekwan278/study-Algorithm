package programmers.intro.ctrlZ;

// 숫자와 "Z"가 공백으로 구분되어 담긴 문자열이 주어집니다. 문자열에 있는 숫자를
// 차례대로 더하려고 합니다. 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻입니다.
// 숫자와 "Z"로 이루어진 문자열 s가 주어질 때, 머쓱이가 구한 값을 return
// 하도록 solution 함수를 완성해보세요.

import utils.Compare;

import java.util.Stack;

public class CtrlZ {

    public int solutionA(String s) {
        int answer = 0;

        String[] strArr = s.split(" ");

        for(int i = 0; i < strArr.length; i++){
            if(strArr[i].equals("Z")){
                answer -= Integer.parseInt(strArr[i-1]);
            }else{
                answer += Integer.parseInt(strArr[i]);
            }
        }

        return answer;
    }
    // Stack
    public int solutionB(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (String w : s.split(" ")) {
            if (w.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(w));
            }
        }
        for (int i : stack) {
            answer += i;
        }
        return answer;
    }

    public static void main(String[] args) {
        CtrlZ task = new CtrlZ();
        String str = "-1 -2 -3 Z";
        System.out.println(task.solutionA(str));
        Compare.measureTime(()-> task.solutionA(str), ()-> task.solutionB(str));
    }

}
