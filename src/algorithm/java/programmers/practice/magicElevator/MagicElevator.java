package programmers.practice.magicElevator;

// 마법의 엘리베이터

public class MagicElevator {

    ///  try1 - divNum
    public int solution(int storey){
        int answer = 0;

        int cur = storey;

        while(cur > 0){

            int mod = cur % 10;
            cur /= 10;

            if(mod > 5){
                answer += (10 - mod);
                cur++;
            }else if(mod == 5){
                if((cur % 10) >= 5){
                    cur++;
                }
                answer += 5;
            }else{
                answer += mod;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MagicElevator task = new MagicElevator();

        int storey = 2554;

        System.out.println(task.solution(storey));
    }

}
