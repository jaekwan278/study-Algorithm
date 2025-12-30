package programmers.basicTraining.findLongestString;

// 특정 문자열로 끝나는 가장 긴 부분 문자열 찾기

public class FindLongestString {

    public String solution(String myString, String pat) {
        String reverse = new StringBuilder(myString).reverse().toString();
        String target = new StringBuilder(pat).reverse().toString();
        int idx = 0;

        for(int i = 0; i < reverse.length(); i++){
            if(reverse.substring(i, (i + pat.length())).equals(target)){
                idx = myString.length() - i;
                break;
            }
        }

        return myString.substring(0, idx);
    }

    public String solution2(String myString, String pat){
        System.out.println(myString.lastIndexOf(pat));
        return myString.substring(0, myString.lastIndexOf(pat) + pat.length());
    }

    public static void main(String[] args) {
        FindLongestString task = new FindLongestString();
        String myString = "AAAAaaaa";
        String pat = "a";

        System.out.println(task.solution2(myString, pat));
    }
}
