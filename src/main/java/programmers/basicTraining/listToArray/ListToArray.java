package programmers.basicTraining.listToArray;

// 문자 리스트를 문자열로 변환하기

public class ListToArray {

    public String solution(String[] arr) {
        StringBuilder sb = new StringBuilder();

        for(String str : arr){
            sb.append(str);
        }

        return sb.toString();
    }

    public String solution2(String[] arr){
        return String.join("", arr);
    }
}
