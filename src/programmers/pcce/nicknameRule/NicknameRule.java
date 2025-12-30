package programmers.pcce.nicknameRule;

// 닉네임 규칙

public class NicknameRule {

    public String solution(String nickname) {
        String answer = "";
        for(int i=0; i<nickname.length(); i++){
            if(nickname.charAt(i) == 'l'){
                answer += "I";
            }
            else if(nickname.charAt(i) == 'w'){
                answer += "vv";
            }
            else if(nickname.charAt(i) == 'W'){
                answer += "VV";
            }
            else if(nickname.charAt(i) == 'O'){
                answer += "0";
            }
            else{
                answer += nickname.charAt(i);
            }
        }
        while(answer.length() < 4){
            answer += "o";
        }
        if(answer.length() > 8){
            answer = answer.substring(0, 8);
        }
        return answer;
    }

    public static void main(String[] args) {
        NicknameRule task = new NicknameRule();
        String s = "aaaaaaaaaaaaaa";
        System.out.println(task.solution(s));
    }

}
