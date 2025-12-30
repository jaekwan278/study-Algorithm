package programmers.basicTraining.rny_string;

// 나머지 구하기

public class RNY_String {

    public String solution(String rny_string) {

        return rny_string.replaceAll("m", "rn");
    }

    public static void main(String[] args) {
        RNY_String task = new RNY_String();
        String rny_string = "masterpiece";

        System.out.println(task.solution(rny_string));
    }

}
