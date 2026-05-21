package programmers.basicTraining.stringAssembler;

// 부분 문자열 이어 분쳐 문자열 만들기

public class StringAssembler {

    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";

        for(int i = 0; i < parts.length; i++){
            answer += my_strings[i].substring(parts[i][0], parts[i][1]+1);
        }

        return answer;
    }

    public static void main(String[] args) {
        StringAssembler task = new StringAssembler();
        String[] my_strings = {"progressive", "hamburger", "hammer", "ahocorasick"};
        int[][] parts = {{0, 4}, {1, 2}, {3, 5}, {7, 7}};

        System.out.println(task.solution(my_strings, parts));
    }

}
