package programmers.basicTraining.convertToL;

// i 로 만들기

public class ConvertToL {

    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();

        for(char ch : myString.toCharArray()){
            if(ch <= 'l'){
                sb.append("l");
            }else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public String solution2(String myString){
        return myString.replaceAll("[a-l]", "l");
    }

    public static void main(String[] args) {
        ConvertToL task = new ConvertToL();
        String myString = "abcdevwxyz";

        System.out.println(task.solution(myString));
    }
}
