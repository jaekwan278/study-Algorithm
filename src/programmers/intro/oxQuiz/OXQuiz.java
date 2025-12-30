package programmers.intro.oxQuiz;

// O X 퀴즈

// 덧셈, 뺄셈 수식들이 'X [연산자] Y = Z' 형태로 들어있는 문자열 배열 quiz가 매개변수로 주어집니다.
// 수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 return하도록 solution 함수를 완성해주세요.

// 연산 기호와 숫자 사이는 항상 하나의 공백이 존재합니다. 단 음수를 표시하는 마이너스 기호와 숫자 사이에는 공백이 존재하지 않습니다.
// 1 ≤ quiz의 길이 ≤ 10
// X, Y, Z는 각각 0부터 9까지 숫자로 이루어진 정수를 의미하며, 각 숫자의 맨 앞에 마이너스 기호가 하나 있을 수 있고 이는 음수를 의미합니다.
// X, Y, Z는 0을 제외하고는 0으로 시작하지 않습니다.
// -10,000 ≤ X, Y ≤ 10,000
// -20,000 ≤ Z ≤ 20,000
// [연산자]는 + 와 - 중 하나입니다.

import utils.Compare;

import java.util.Arrays;

public class OXQuiz {

    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] task = quiz[i].split("=");
            String[] left = task[0].trim().split(" ");
            String right = task[1].trim();
            int result = Integer.parseInt(left[0]);
            for (int j = 1; j <= left.length / 2; j += 2) {
                if (left[j].equals("+")) {
                    result += Integer.parseInt(left[j + 1]);
                } else {
                    result -= Integer.parseInt(left[j + 1]);
                }
            }

            if (result == Integer.parseInt(right)) answer[i] = "O";
            else answer[i] = "X";
        }

        return answer;
    }

    public String[] solution2(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] str = quiz[i].split(" ");
            int left = (str[1].equals("+"))
                    ? Integer.parseInt(str[0]) + Integer.parseInt(str[2])
                    : Integer.parseInt(str[0]) - Integer.parseInt(str[2]);
            if (left == Integer.parseInt(str[4])){
                answer[i] = "O";
            }else{
                answer[i] = "X";
            }
        }

        return answer;
    }

    public String[] solution3(String[] quiz) {
        for(int i=0; i<quiz.length; i++){
            String[] text = quiz[i].split(" ");
            int result = Integer.parseInt(text[0]) + ( Integer.parseInt(text[2]) * ( text[1].equals("+") ? 1:-1) );
            quiz[i] = result == Integer.parseInt(text[4])? "O": "X";
        }
        return quiz;
    }

    public static void main(String[] args) {
        OXQuiz task = new OXQuiz();
        String[] quiz = {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"};

//        System.out.println(Arrays.toString(task.solution2(quiz)));

        Compare.measureTime(() -> task.solution(quiz), () -> task.solution3(quiz));
    }

}
