package programmers.kakao.makeingTwoQueuesSumsEqual;

// 두 큐 합 같게 만들기

import java.util.Arrays;

public class MakingTwoQueuesSumsEqual {
    // try 1 ( pass )
    private static class Box{
        private int head;
        private int tail;
        private int sum;

        private Box(int head, int tail, int sum){
            this.head = head;
            this.tail = tail;
            this.sum = sum;
        }

        private void in(int value){
            this.tail++;
            this.sum += value;
        }

        private void out(int value){
            this.head++;
            this.sum -= value;
        }
    }
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int len = queue1.length;

        int[] arr = new int[len * 4];
        int sum1 = 0, sum2 = 0;

        for(int i = 0; i < len; i++){
            sum1 += queue1[i];
            sum2 += queue2[i];

            arr[i] = arr[i + len * 2] = queue1[i];
            arr[i+len] = arr[i + len * 3] = queue2[i];
        }

        if ((sum1 + sum2) % 2 == 1){
            return -1;
        }

        Box left = new Box(0, len - 1, sum1);
        Box right = new Box(len, len * 2 - 1, sum2);

        while(left.sum != right.sum) {

            if (left.sum > right.sum) {
                int value = arr[left.head];

                left.out(value);
                right.in(value);
            } else {
                int value = arr[right.head];

                left.in(value);
                right.out(value);
            }

            answer++;

            if (right.tail >= arr.length) {
                return -1;
            }
        }

        return answer;
    }

    // try 2
    public int solution2(int[] queue1, int[] queue2){
        int answer = 0;

        int len = queue1.length;
        int[] arr = new int[len * 2];

        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < len; i++){
            arr[i] = queue1[i];
            arr[i + len] = queue2[i];

            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        if((sum1 + sum2) % 2 == 1) return -1;

        long target = (sum1 + sum2) / 2;
        long cur = sum1;

        int left = 0;
        int right = len;
        while(answer <= (len * 3)){

            if(cur == target) return answer;

            if(cur < target){
                cur += arr[right % (len * 2)];
                right++;
            }else{
                cur -= arr[left % (len * 2)];
                left++;
            }

            answer++;
        }

        return -1;
    }

    // other
    public int solution3(int[] queue1, int[] queue2) {
        int[] totalQueue = new int[queue1.length + queue2.length];
        long queue1Sum = 0;
        long queue2Sum = 0;

        for(int i = 0; i < queue1.length; i++) {
            int val = queue1[i];
            totalQueue[i] = val;
            queue1Sum += val;
        }

        for(int i = queue1.length; i < queue1.length + queue2.length; i++) {
            int val = queue2[i - queue1.length];
            totalQueue[i] = val;
            queue2Sum += val;
        }

        if((queue1Sum + queue2Sum) % 2 == 1) return -1;

        int count = 0;
        int left = 0;
        int right = queue1.length;
        long half = (queue1Sum + queue2Sum) / 2;
        while(left < right && right < totalQueue.length) {
            if(queue1Sum == half) {
                return count;
            } else if(queue1Sum > half) {
                queue1Sum -= totalQueue[left++];
            } else {
                queue1Sum += totalQueue[right++];
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        MakingTwoQueuesSumsEqual task = new MakingTwoQueuesSumsEqual();

        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

        System.out.println(task.solution2(queue1, queue2));
    }

}
