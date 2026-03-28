package programmers.kakao.arrayOfSquareCnt;

import java.util.Arrays;

public class ArrayOfSquareCnt2 {

    public long[] solution(int[] arr, long l, long r) {
        long[] answer = new long[2];
        // answer[0]
        answer[0] = getSum(arr, l, r);

        // length accumulation array
        long[] lenArr = getLenArr(arr);
        long len = (r - l + 1);

        // if range length == 1 ?
        if(len == 1){
            for (int n : arr) if (n == answer[0]) answer[1] += n;

            return answer;
        }

        // answer[1]
        answer[1] = getValidRangeCount(arr, lenArr, answer[0], len);

        return answer;
    }

    // answer[1]
    private long getValidRangeCount(int[] arr, long[] lenArr, long target, long len){
        long result = 0;

        int startIdx = 0;
        int endIdx = 0;

        long curIdx = 0;
        long curSum = 0;

        long idx = len;


//        while(curIdx <= (lenArr[lenArr.length - 1] - len)){
//
//        }

        return result;
    }

    // length accumulation array
    private long[] getLenArr(int[] arr){
        long[] result = new long[arr.length];
        result[0] = arr[0];

        for(int i = 1; i < arr.length; i++) result[i] = arr[i] + result[i-1];

        return result;
    }

    // answer[0]
    private long getSum(int[] arr, long l, long r){
        long result = 0;

        long idx = 1;
        for(int cur : arr){
            long start = idx;
            long end = idx + cur - 1;

            if(start > r) break;

            if(end < l) {
                idx += cur;
                continue;
            }

            long from = Math.max(l, start);
            long to = Math.min(end, r);

            result += cur * (to - from + 1);
            idx += cur;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayOfSquareCnt2 task = new ArrayOfSquareCnt2();

//        int[] arr = {2, 2, 2};
//        int l = 2, r = 2;

//        int[] arr = {3, 2, 3, 1, 1};
//        int l = 5, r = 7;
//
        int[] arr = {8, 8, 6, 5, 2, 9, 8, 4, 3, 10};
        int l = 10, r = 27;
//
//        int[] arr = {49134, 86806, 94548, 88849, 95022, 28334, 16637, 79487, 23773, 7314, 47370, 50269, 36573, 9415, 44674, 28096};
//        int l = 61242, r = 88535;

        System.out.println(Arrays.toString(task.solution(arr, l, r)));
    }

}
