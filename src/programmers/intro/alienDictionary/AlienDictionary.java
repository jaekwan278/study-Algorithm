package programmers.intro.alienDictionary;

// 외계어 사전

// PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다.
// 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다.
// spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.

import java.util.Arrays;

public class AlienDictionary {

    public int solution(String[] spell, String[] dic) {
        int answer = 0;

        char[] spellArr = new char[spell.length];

        for(int i = 0; i < spellArr.length; i++){
            spellArr[i] = spell[i].charAt(0);
        }

        Arrays.sort(spellArr);

        String spellStr = new String(spellArr);

        for(int i = 0; i < dic.length; i++){
            char[] chars = dic[i].toCharArray();
            Arrays.sort(chars);

            if(spellStr.equals(new String(chars))) return 1;
        }

        return 2;
    }

    // 중복 개수 카운트
    public int solution2(String[] spell, String[] dic) {
        for(int i=0;i<dic.length;i++){
            int answer = 0;
            for(int j=0;j<spell.length;j++){
                if(dic[i].contains(spell[j])) answer ++;
            }
            if(answer==spell.length) return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        AlienDictionary task = new AlienDictionary();
        String[] spell = {"s", "o", "m", "d"};
        String[] dic = {"moos", "dzx", "smm", "sunmmo", "som", "msodd"};

        System.out.println(task.solution(spell, dic));
    }
}
