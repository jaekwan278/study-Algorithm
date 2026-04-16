package programmers.kakao.compression;

// 압축

import java.util.*;

public class Compression {

    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        TrieNode trieNode = new TrieNode(1);

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            map.put("" + (char)('A' + i), i + 1);
        }

        int idx = 27;
        for(int i = 0; i < msg.length();){
            int j = i + 1;

            while(j <= msg.length() && map.containsKey(msg.substring(i, j))){
                j++;
            }

            String str = msg.substring(i, (j - 1));
            answer.add(map.get(str));

            if(j <= msg.length()) map.put(msg.substring(i, j), idx++);

            i += str.length();
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class TrieNode{
        Map<Character, Integer> ch = new HashMap<>();
        int index;

        TrieNode(int index){
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Compression task = new Compression();

        String msg = "TOBEORNOTTOBEORTOBEORNOT";

        System.out.println(Arrays.toString(task.solution(msg)));
    }

}
