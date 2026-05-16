package programmers.basicTraining.subString;

public class SubString {

    public int solution(String str1, String str2) {

        return (str2.contains(str1)) ? 1 : 0;
    }

    public static void main(String[] args) {
        SubString task = new SubString();
        String str1 = "tbt";
        String str2 = "tbbttb";

        System.out.println(task.solution(str1, str2));
    }

}
