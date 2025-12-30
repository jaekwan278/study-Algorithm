package programmers.intro.hiddenNumberAdd;

public class HiddenNumberAdd {
    public int solution(String my_string) {
        int answer = 0;

        String[] arr = my_string.split("[^0-9]+");
        for(String str : arr){
            if(!str.isEmpty()){
                answer += Integer.parseInt(str);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        HiddenNumberAdd task = new HiddenNumberAdd();

        System.out.println(task.solution("aAb1B2cC34oOp"));
    }
}
