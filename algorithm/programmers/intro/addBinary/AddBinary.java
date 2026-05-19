package programmers.intro.addBinary;

// 이진수를 의미하는 두 개의 문자열 bin1과 bin2가 매개변수로 주어질 때, 두 이
// 진수의 합을 return하도록 solution 함수를 완성해주세요.

import utils.Compare;

public class AddBinary {

    public String solution(String bin1, String bin2) {
        String answer = "";

        int num1 = Integer.parseInt(bin1, 2);
        int num2 = Integer.parseInt(bin2, 2);

        int sum = num1 + num2;

        answer = Integer.toBinaryString(sum);

        return answer;
    }

    public String solution2(String bin1, String bin2){
        int length = Math.max(bin1.length(), bin2.length());

        bin1 = String.format("%" + length + "s", bin1).replace(' ', '0');
        bin2 = String.format("%" + length + "s", bin2).replace(' ', '0');

        StringBuilder sb = new StringBuilder();

        int add = 0;

        for(int i = length - 1; i >= 0; i--){
            int sum = (bin1.charAt(i) - '0') + (bin2.charAt(i) - '0') + add;

            if(sum > 2){
                sb.append(1);
                add = 1;
            }else if(sum > 1){
                sb.append(0);
                add = 1;
            }else if(sum > 0){
                sb.append(1);
                add = 0;
            }else{
                sb.append(0);
                add = 0;
            }
        }

        if(add > 0){
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary task = new AddBinary();

        String bin1 = "10101";
        String bin2 = "01011";

        System.out.println(task.solution(bin1, bin2));

        Compare.measureTime(() -> task.solution(bin1, bin2), () -> task.solution2(bin1, bin2));
        // A win
    }

}
