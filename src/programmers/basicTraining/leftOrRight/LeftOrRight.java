package programmers.basicTraining.leftOrRight;

// 왼쪽 오른쪽

import java.util.Arrays;

public class LeftOrRight {

    public String[] solution(String[] str_list) {

        for(int i = 0; i < str_list.length; i++){
            if(str_list[i].equals("l")){
                return Arrays.copyOfRange(str_list, 0, i);
            }else if(str_list[i].equals("r")){
                return Arrays.copyOfRange(str_list, i + 1, str_list.length);
            }
        }

        return new String[]{};
    }

    public static void main(String[] args) {
        LeftOrRight task = new LeftOrRight();
        String[] str_list = {"u", "u", "r", "r"};

        System.out.println(Arrays.toString(task.solution(str_list)));
    }

}
