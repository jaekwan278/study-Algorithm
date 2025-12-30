package programmers.basicTraining.suffixChecker;

import utils.Compare;

public class SuffixChecker {

    public int solution(String my_string, String is_suffix) {
        return my_string.endsWith(is_suffix) ? 1 : 0;
    }

    public int solution2(String my_string, String is_suffix){
        String compare = my_string.substring(is_suffix.length());
        return compare.equals(is_suffix) ? 1 : 0;
    }

    public int solution3(String my_String, String is_suffix){
        char[] charA = my_String.toCharArray();
        char[] charB = is_suffix.toCharArray();

        for(int i = is_suffix.length(); i < my_String.length(); i++){
            if(charA[i] != charB[i - is_suffix.length()]){
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        SuffixChecker task = new SuffixChecker();
        String my_string = "banana";
        String is_suffix = "ana";

        Compare.measureTime(()-> task.solution2(my_string, is_suffix), ()->task.solution3(my_string, is_suffix));
    }

}
