package programmers.exhaustiveSearch.vowelDictionary;

// 모음 사전

public class VowelDictionary {

    public int solution(String word) {
        int answer = 0;

        String vowel = "AEIOU";

        int[] base = new int[5];
        base[0] = 1 + 5 + (int)Math.pow(5, 2) + (int)Math.pow(5, 3) + (int)Math.pow(5, 4);
        base[1] = base[0] - (int)Math.pow(5, 4);
        base[2] = base[1] - (int)Math.pow(5, 3);
        base[3] = base[2] - (int)Math.pow(5, 2);
        base[4] = 1;

        for(int i = 0; i < word.length(); i++){
            answer += vowel.indexOf(word.charAt(i)) * base[i] + 1;
        }

        return answer;
    }


    public static void main(String[] args) {
        VowelDictionary task = new VowelDictionary();
        String word = "EIO";

        System.out.println(task.solution(word));
    }
}
