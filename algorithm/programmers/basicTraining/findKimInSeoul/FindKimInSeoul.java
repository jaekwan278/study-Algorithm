package programmers.basicTraining.findKimInSeoul;

// 서울에서 김서방 찾기

import utils.Compare;

import java.util.Arrays;

public class FindKimInSeoul {

    public String solution(String[] seoul) {
        int index = 0;

        for(String str : seoul){
            if(str.equals("Kim")){
                break;
            }
            index++;
        }

        return "김서방은 " + index + "에 있다";
    }

    public String solution2(String[] seoul){
        //x에 김서방의 위치를 저장하세요.
        int x = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 "+ x + "에 있다";
    }

    public static void main(String[] args) {
        FindKimInSeoul task = new FindKimInSeoul();
        String[] seoul = {"Jane", "Kim"};

        System.out.println(task.solution(seoul));

        Compare.measureTime(()->task.solution(seoul), ()->task.solution2(seoul));
    }

}
