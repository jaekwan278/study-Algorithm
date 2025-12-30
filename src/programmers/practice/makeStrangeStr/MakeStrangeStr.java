package programmers.practice.makeStrangeStr;

public class MakeStrangeStr {

    public String solution(String s) {
        char[] arr = s.toCharArray();

        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ' '){
                idx = 0;
            }else{
                arr[i] = (idx++ % 2 == 0) ? Character.toUpperCase(arr[i]) : Character.toLowerCase(arr[i]);
            }
        }

        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        MakeStrangeStr task = new MakeStrangeStr();
        String s = "TRY hello world";

        System.out.println(task.solution(s));
    }

}
