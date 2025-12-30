package programmers.hash.unFinishedRunner;

// 완주하지 못한 선수

import java.util.HashMap;

public class UnFinishedRunner {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for(String c : completion){
            map.put(c, map.get(c) - 1);
        }

        for(String key : map.keySet()){
            if(map.get(key) != 0){
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        UnFinishedRunner task = new UnFinishedRunner();

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(task.solution(participant, completion));

    }

}
