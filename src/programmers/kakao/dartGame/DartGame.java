package programmers.kakao.dartGame;

// 다트 게임

public class DartGame {

    public int solution(String dartResult) {
        int answer = 0;

        String[] scoreArr = makeArr(dartResult);

        int[] result = scoreCalc(scoreArr);

        for(int n : result){
            answer += n;
        }

        return answer;
    }

    private String[] makeArr(String dartResult){
        String[] result = new String[3];

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(char cur : dartResult.toCharArray()){

            if(sb.isEmpty()){
                sb.append(cur);
            }else{
                char prev = sb.charAt(sb.length()-1);

                if(Character.isDigit(cur) && (Character.isUpperCase(prev) || prev == '*' || prev == '#')){
                    result[idx++] = sb.toString();

                    sb.setLength(0);
                    sb.append(cur);
                }else{
                    sb.append(cur);
                }
            }
        }

        result[idx] = sb.toString();

        return result;
    }

    private int[] scoreCalc(String[] scoreArr){
        int[] result = new int[3];

        int idx = 0;
        for(String str : scoreArr){

            StringBuilder scoreStr= new StringBuilder();
            char option = ' ';

            for(char ch : str.toCharArray()){

                if(Character.isDigit(ch)){
                    scoreStr.append(ch);
                }
                else if(Character.isUpperCase(ch)){
                    int score = Integer.parseInt(scoreStr.toString());

                    if(ch == 'D'){
                        score = (int)Math.pow(score, 2);
                    }else if(ch == 'T'){
                        score = (int)Math.pow(score, 3);
                    }

                    result[idx] = score;
                }
                else{
                    option = ch;
                }
            }
            if(option == '*'){
                result[idx] *= 2;
                if(idx > 0){
                    result[idx - 1] *= 2;
                }
            }
            else if(option == '#'){
                result[idx] *= -1;
            }

            idx++;
        }

        return result;
    }

    public static void main(String[] args) {
        DartGame task = new DartGame();

        String dartResult = "1D#2S*3S";

        System.out.println(task.solution(dartResult));
    }

}
