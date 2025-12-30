package programmers.basicTraining.hidePhoneNumber;

// 핸드폰 번호 가리기

public class HidePhoneNumber {

    public String solution(String phone_number) {

        return "*".repeat(phone_number.length()-4) + phone_number.substring(phone_number.length() - 4);
    }

}
