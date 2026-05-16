package programmers.intro.throwBall;

// 공 던지기

// 머쓱이는 친구들과 동그랗게 서서 공 던지기 게임을 하고 있습니다. 공은 1번부터 던
// 지며 오른쪽으로 한 명을 건너뛰고 그다음 사람에게만 던질 수 있습니다. 친구들의 번
// 호가 들어있는 정수 배열 numbers와 정수 K가 주어질 때, k번째로 공을 던지
// 는 사람의 번호는 무엇인지 return 하도록 solution 함수를 완성해보세요.

public class ThrowBall {

    public int solution(int[] numbers, int k) {
        int answer = 0;
        int length = numbers.length;
        int cnt = 0;

        for(int i = 0; i < (k-1); i++){
            cnt += 2;
            if(cnt >= length){
                cnt %= (length);
            }
        }

        answer = numbers[cnt];

        return answer;
    }
    public int solution2(int[] numbers, int k) {
        return (k-1)*2 % numbers.length+1;
    }

    public static void main(String[] args) {
        ThrowBall task = new ThrowBall();
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 5;

        System.out.println(task.solution2(nums, k));
    }
}
