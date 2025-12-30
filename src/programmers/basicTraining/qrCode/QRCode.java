package programmers.basicTraining.qrCode;

// qr code

public class QRCode {

    public String solution(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();

        for(int i = r; i < code.length(); i += q){
            sb.append(code.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        QRCode task = new QRCode();
        int q = 3, r = 1;
        String code = "qjnwezgrpirldywt";

        System.out.println(task.solution(q,r,code));
    }

}
