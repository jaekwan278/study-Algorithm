package utils;

/*

1. ) 시작 하면 false
2. ( == )
3. ) 개수가 ( 개수를 넘으면 안됨

 */

public class Temp {

    boolean solution(String s) {
        int left = 0, right = 0;
        char[] arr = {'(', ')'};

        for(char ch : s.toCharArray()){
            if(ch == arr[0]) left++;
            else right++;

            if(right > left) return false;
        }

        return left == right;
    }

    public static void main(String[] args) {

    }

}
