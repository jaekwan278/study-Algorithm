package programmers.practice.babbling2;

// 옹알이 (2)

import utils.Compare;

public class Babbling2 {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] possible = {"aya", "ye", "woo", "ma"};

        for(String cur : babbling){

            String prev = "";

            while(true){

                boolean con = false;

                for(String pos : possible){

                    if(cur.startsWith(pos) && !prev.equals(pos)){
                        cur = cur.substring(pos.length());
                        prev = pos;
                        con = true;
                        break;
                    }
                }

                if(!con) break;
            }

            if(cur.isEmpty()) answer++;
        }

        return answer;
    }

    public int solution2(String[] babblings) {
        // "aya", "ye", "woo", "ma" 4가지 발음만 가능
        int answer = 0;
        for(int i = 0; i < babblings.length; i++) {
            if(babblings[i].contains("ayaaya") || babblings[i].contains("yeye") || babblings[i].contains("woowoo") || babblings[i].contains("mama")) {
                continue;
            }

            babblings[i] = babblings[i].replace("aya", " ");
            babblings[i] = babblings[i].replace("ye", " ");
            babblings[i] = babblings[i].replace("woo", " ");
            babblings[i] = babblings[i].replace("ma", " ");
            babblings[i] = babblings[i].replace(" ", "");

            if(babblings[i].isEmpty()) answer++;

        }
        return answer;
    }

    public static void main(String[] args) {
        Babbling2 task = new Babbling2();

        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        System.out.println(task.solution(babbling));

        Compare.measureTime(()->task.solution(babbling), ()->task.solution2(babbling));
    }
}
