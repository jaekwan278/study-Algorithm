package programmers.practice.stringHandle;

// 문자열 다루기 기본

public class StringHandle {

    public boolean solution(String s) {
        return s.matches("\\d+") && (s.length() == 4 || s.length() == 6);
    }

}
