package programmers.basicTraining.tailString;

// 꼬리 문자열

public class TailString {

    public String solution(String[] str_list, String ex) {
        StringBuilder answer = new StringBuilder();

        for(String str : str_list){
            if(str.contains(ex)){
                continue;
            }
            answer.append(str);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        TailString task = new TailString();
        String[] str_list = {"abc", "def", "ghi"};
        String ex = "ef";

        System.out.println(task.solution(str_list, ex));
    }
}
