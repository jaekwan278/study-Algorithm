package programmers.basicTraining.findString;

// 문자열 바꿔서 찾기

import utils.Compare;

public class FindString {

    public int solution(String myString, String pat) {

        StringBuilder sb = new StringBuilder();

        for(char ch : pat.toCharArray()){
            if (ch == 'A') {
                sb.append('B');
            }else{
                sb.append('A');
            }
        }
        System.out.println(sb.toString());

        return (myString.contains(sb.toString())) ? 1 : 0;
    }

    public int solution2(String myString, String pat) {
        myString = myString.replace("A", "a").replace("B", "A").replace("a", "B");
        return myString.contains(pat) ? 1 : 0;
    }

    public static void main(String[] args) {
        FindString task = new FindString();
        String myString = "ABBAA";
        String pat = "AABB";

        System.out.println(task.solution(myString, pat));

        Compare.measureTime(()->task.solution(myString, pat), ()->task.solution2(myString, pat));
    }
}
