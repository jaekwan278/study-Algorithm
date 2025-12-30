package programmers.stackQue.rightParentheses;

// 올바른 괄호

public class RightParentheses {

    public boolean solution(String s) {

        int left = 0;
        int right = 0;

        for(char ch : s.toCharArray()){
            if(ch == '(') left++;
            if(ch == ')') right++;

            if(left < right){
                return false;
            }
        }

        return left == right;
    }

}
