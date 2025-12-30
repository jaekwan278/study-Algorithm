package programmers.intro.bitMask;

// 모음 제거

/*
    영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다.
    문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
 */

import utils.Compare;

/*
    "bus" = "bs"
    "nice to meet you" = "nc t mt y"
 */
public class BitMask {

    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        int mask = 0;

        mask |= (1 << ('a' - 'a'));
        mask |= (1 << ('e' - 'a'));
        mask |= (1 << ('i' - 'a'));
        mask |= (1 << ('o' - 'a'));
        mask |= (1 << ('u' - 'a'));

        for(char chr : my_string.toCharArray()){
            if((mask & (1 << (chr - 'a'))) == 0){
                sb.append(chr);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        BitMask bitMask = new BitMask();
        Compare compare = new Compare();
        String msg = "hello world";

        System.out.println(bitMask.solution(msg));
    }
}
