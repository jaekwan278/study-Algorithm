package programmers.practice.caesarCipher;

// 시저 암호

import programmers.basicTraining.caseConverter.CaseConverter;

public class CaesarCipher {

    public String solution(String s, int n) {
        n %= 26;
        StringBuilder sb = new StringBuilder(s.length());

        for(char ch : s.toCharArray()){
            if(ch == ' '){
                sb.append(ch);
                continue;
            }

            if(Character.isUpperCase(ch)){
                sb.append(
                        (char)((ch - 'A' + n) % 26 + 'A')
                );
            }else{
                sb.append(
                        (char)((ch - 'a' + n) % 26 + 'a')
                );
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        CaesarCipher task = new CaesarCipher();
        String s = "a B z";
        int n = 1;

        System.out.println(task.solution(s, n));
    }
}
