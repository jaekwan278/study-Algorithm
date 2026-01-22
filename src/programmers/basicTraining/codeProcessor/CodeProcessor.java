package programmers.basicTraining.codeProcessor;

// 코드 처리하기

public class CodeProcessor {

    public String solution(String code) {
        StringBuilder sb = new StringBuilder();

        boolean mode = false;

        for(int i = 0; i < code.length(); i++){

            char cur = code.charAt(i);

            if(cur == '1'){
                mode = !mode;
                continue;
            }

            if( (!mode && i % 2 == 0) || (mode && i % 2 == 1)){
                sb.append(cur);
            }

        }

//        return sb.length() == 0 ? "EMPTY" : sb.toString();
        return sb.isEmpty() ? "EMPTY" : sb.toString();
    }

    public static void main(String[] args) {
        CodeProcessor task = new CodeProcessor();
        String code = "abc1abc1abc";

        System.out.println(task.solution(code));
    }

}
