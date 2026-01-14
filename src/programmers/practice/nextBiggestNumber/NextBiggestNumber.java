package programmers.practice.nextBiggestNumber;

// 다음 큰 숫자

public class NextBiggestNumber {

    public int solution(int n) {
        int answer = n+1;
        int nCnt = Integer.bitCount(n);

        while(Integer.bitCount(answer) != nCnt){
            answer++;
        }

        return answer;
    }

    public int solution2(int n){
        int answer = 0;
        int firstBit = Integer.lowestOneBit(n);

        answer = firstBit + n;

        int diff = n ^ answer;
        // 01 -> 10 : 2 bit 제거
        diff >>= 2;

        // 첫번째 1 비트 까지 오른쪽으로 시프트 >> : 유효한 비트 오른쪽 정렬
        diff /= firstBit;

        return answer | diff;
    }


    /*

        1001000
        0011000

     */

    public static void main(String[] args) {
        NextBiggestNumber task = new NextBiggestNumber();
        int n = 78;

//        System.out.println(task.solution(n));

        System.out.println(task.solution2(n));
    }

}
