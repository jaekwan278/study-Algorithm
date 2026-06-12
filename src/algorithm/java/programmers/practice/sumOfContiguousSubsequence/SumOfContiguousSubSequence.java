package programmers.practice.sumOfContiguousSubsequence;

// 연속된 부분 수열의 합

import java.util.Arrays;

public class SumOfContiguousSubSequence {

    /// try 1 (pass) - tail to head
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int len = sequence.length - 1;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= len; i++){

            int curSum = 0;
            int curLen = len - i;
            for(int j = curLen; j >= 0; j--){

                curSum += sequence[j];

                if(curSum == k && (curLen - j) <= min){
                    min = curLen - j;

                    answer[0] = j;
                    answer[1] = curLen;
                }

                if(curSum > k){
                    break;
                }

                if(curSum < k && j == 0){
                    return answer;
                }
            }
        }

        return answer;
    }

    /// try 2 (pass) - two pointer
    public int[] solution2(int[] sequence, int k){
        int[] answer = new int[2];

        int sum = 0;
        int left = 0;

        int minLen = Integer.MAX_VALUE;

        for(int right = 0; right < sequence.length; right++){

            sum += sequence[right];

            while(sum > k){
                sum -= sequence[left++];
            }

            if(sum == k && (right - left) < minLen){
                minLen = right - left;

                answer[0] = left;
                answer[1] = right;
            }
        }

        return answer;
    }

    ///  other 1
    public int[] solution3(int[] sequence, int k) {

        int left = 0, right = -1, sum = 0;
        int length = 1000001, sLeft = 0, sRight = 0;

        while (right < sequence.length) {

            if (sum < k) {
                if (++right < sequence.length)
                    sum += sequence[right];
            } else if (k < sum) {
                sum -= sequence[left++];
            } else {
                if (right - left < length) {
                    length = right - left;
                    sLeft = left;
                    sRight = right;
                }
                sum -= sequence[left++];
            }
        }
        return new int[] { sLeft, sRight };
    }

    public static void main(String[] args) {
        SumOfContiguousSubSequence task = new SumOfContiguousSubSequence();

        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;

        System.out.println(Arrays.toString(task.solution2(sequence, k)));
    }
}
