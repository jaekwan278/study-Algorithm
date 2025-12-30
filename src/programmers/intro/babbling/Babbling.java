package programmers.intro.babbling;

import java.util.HashSet;

// 옹알이 문제
/*
    머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다.
    조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다.
    문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 */
/*
    1 ≤ babbling의 길이 ≤ 100
    1 ≤ babbling[i]의 길이 ≤ 15
    babbling의 각 문자열에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다.
    즉, 각 문자열의 가능한 모든 부분 문자열 중에서 "aya", "ye", "woo", "ma"가 한 번씩만 등장합니다.
    문자열은 알파벳 소문자로만 이루어져 있습니다.
 */
/*
    - char 비교.
 */
public class Babbling {

    public int solution(String[] babbling) {
        int answer = 0;

        HashSet<String> compareList = new HashSet<>();
        compareList.add("aya");
        compareList.add("ye");
        compareList.add("woo");
        compareList.add("ma");

        boolean[] result = new boolean[babbling.length];

        for (String word : babbling) {
            if (isContain(word, compareList, 0)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isContain(String word, HashSet<String> list, int index){
        if(index == word.length()){
            return true;
        }
        for(int i = index + 1; i <= word.length(); i++){
            String subString = word.substring(index, i);
            if(list.contains(subString) && isContain(word, list, i)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        Babbling test = new Babbling();

        System.out.println(test.solution(babbling));
    }

}
