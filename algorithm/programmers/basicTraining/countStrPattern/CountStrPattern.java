package programmers.basicTraining.countStrPattern;

// 문자열이 몇 번 등장하는지 세기

import utils.Compare;

public class CountStrPattern {

    public int solution(String myString, String pat) {
        int answer = 0;

        char[] strArr = myString.toCharArray();
        char[] patArr = pat.toCharArray();
        int cnt = 0;

        for(int i = 0; i <= (myString.length() - pat.length()); i++){
            cnt = 0;
            while(cnt < pat.length() && strArr[i+cnt] == patArr[cnt]){
                cnt++;
            }
            if(cnt == pat.length()){
                answer++;
            }
        }

        return answer;
    }

    public int solution2(String myString, String pat){
        int answer = 0;

        for(int i = 0; i <= myString.length() - pat.length(); i++){
            if(myString.startsWith(pat, i)){
                answer++;
            }
        }

        return answer;
    }

    public int solution3(String myString, String pat){
        int answer = 0;
        int index = 0;

        while((index = myString.indexOf(pat, index)) != -1){
            answer++;
            index++;
        }

        return answer;
    }

    public static void main(String[] args) {
        CountStrPattern task = new CountStrPattern();
        String myString = "banana";
        String pat = "ana";

//        System.out.println(task.solution3(myString, pat));

        Compare.measureTime(()->task.solution2(myString, pat), ()->task.solution3(myString, pat));
    }

}
