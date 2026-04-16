package programmers.kakao.compression;

// 압축

import utils.Compare;

import java.util.*;

public class Compression {

    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        int idx = 1;
        for(char ch = 'A'; ch <= 'Z'; ch++) map.put(String.valueOf(ch), idx++);

        for(int i = 0; i < msg.length();){
            int j = i + 1;

            while(j <= msg.length() && map.containsKey(msg.substring(i, j))) j++;

            String str = msg.substring(i, j-1);
            answer.add(map.get(str));

            if(j <= msg.length()) map.put(msg.substring(i, j), idx++);

            i += str.length();
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(String msg) {
        ArrayList<String> dic = new ArrayList<String>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0 ; i < 26; i++) {
            dic.add(String.valueOf((char)('A'+i)));
        }

        for(int i = 0 ; i < msg.length() ; i++) {
            for(int j = dic.size()-1 ; j >= 0 ; j--) {
                if(msg.substring(i).startsWith(dic.get(j))) {
                    i += dic.get(j).length()-1;
                    result.add(j+1);
                    if(i+1 < msg.length())
                        dic.add(dic.get(j)+msg.charAt(i+1));
                    break;
                }
            }
        }

        int[] answer = new int[result.size()];

        for(int i = 0 ; i < result.size() ; i++)
            answer[i] = result.get(i);

        return answer;
    }

    public static void main(String[] args) {
        Compression task = new Compression();

        String msg = "TOBEORNOTTOBEORTOBEORNOT";

        System.out.println(Arrays.toString(task.solution(msg)));

        Compare.measureTime(()->task.solution(msg), ()->task.solution2(msg));
    }
}
