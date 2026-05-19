package programmers.basicTraining.stringMaker;

// 글자 이어 붙여 문자열 만들기

public class StringMaker {

    public String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();

        for(int index : index_list){
            sb.append(my_string.charAt(index));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        StringMaker task = new StringMaker();
        String my_string = "cvsgiorszzzmrpaqpe";
        int[] index_list = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};

        System.out.println(task.solution(my_string, index_list));
    }
}
