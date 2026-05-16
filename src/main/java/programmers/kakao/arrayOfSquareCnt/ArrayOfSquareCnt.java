package programmers.kakao.arrayOfSquareCnt;

// 제곱 개수 배열

import java.util.*;

/*

K = brr의 l번째 원소부터 r번째 원소까지의 합 = brr[l-1] + brr[l] + brr[l+1] + ... + brr[r-2] + brr[r-1]
C = 길이가 r - l + 1인 brr의 부분 배열 중 합이 K인 부분 배열의 개수

 */

public class ArrayOfSquareCnt {

    public long[] solution(int[] arr, long l, long r) {
        long[] answer = new long[2];

        answer[0] = getSum(arr, l, r);

        if (l == r) {
            for (int j : arr) {
                if (j == answer[0]) answer[1] += answer[0];
            }
            return answer;
        }

        answer[1] = getSubArrCount(arr, (int) (r - l + 1), answer[0]);

        return answer;
    }

    private long getSum(int[] arr, long l, long r) {
        long result = 0;

        long idx = 1;

        for (int cur : arr) {

            long start = idx;
            long end = start + cur - 1;

            if (start >= r) break;

            if (end < l) {
                idx += cur;
                continue;
            }

            result += cur * (Math.min(r, end) - Math.max(idx, l) + 1);
            idx += cur;
        }

        return result;
    }

    private long getSubArrCount(int[] arr, int len, long target) {
        long result = 0;

        long[] lenArr = getLenArr(arr);

        long[] base = getBaseLenSum(arr, len);
        int leftIdx = 0;
        int rightIdx = (int) base[2];

        long curLen = base[0];
        long curSum = base[1];
//        while (rightIdx < arr.length) {
//            int inVal = arr[rightIdx];
//            int outVal = arr[leftIdx];
//            int offset = inVal - outVal;
//
//            int leftOff = (int)(lenArr[leftIdx] - (curLen - (len - 1)));
//            int rightOff = (int)(lenArr[rightIdx] - curLen);
//
//            int move = Math.min(leftOff, rightOff) + 1;
//            curSum += offset;
//
//            result += findMatchCount(curSum, target, inVal, outVal, move);
//
//            System.out.print("range : " + (curLen - (len - 1)) + "~" + curLen + " , result = " + result );
//            System.out.print(", curSum = " + curSum);
//            System.out.println("    / offset : " + offset + ", move : " + move);
//
//            curLen += move;
//            curSum += (long)offset * move;
//
//            if(curLen > lenArr[rightIdx]) rightIdx++;
//            if((curLen - (len - 1)) > lenArr[leftIdx]) leftIdx++;
//        }
        while (rightIdx < arr.length) {

            int leftOff = (int) (lenArr[leftIdx] - (curLen - (len - 1)));
            int rightOff = (int) (lenArr[rightIdx] - curLen);
            int move = Math.min(leftOff, rightOff) + 1;

            int inVal = arr[rightIdx];
            int outVal = arr[leftIdx];
            int offset = inVal - outVal;

            result += findMatchCount((target - curSum), offset, move);

            curLen += move;
            curSum += (long) offset * move;

            if (curLen > lenArr[rightIdx]) rightIdx++;
            if ((curLen - (len - 1)) > lenArr[leftIdx]) leftIdx++;
        }

        return result;
    }

    // 8 8 8, 8 8 8 .8 8   2 2
    // 2 2 3, 3 3 4 4 4 4

    private int findMatchCount(long diff, int offset, int move) {

        if (diff == 0) {
            if (offset == 0) return move;
            else return 1;
        }

        if(offset == 0) return 0;

        if ( (diff > 0 && offset < 0) || (diff < 0 && offset > 0) ) return 0;

        if ( (diff % offset != 0) || !(Math.abs(diff / offset) <= move)) return 0;

        return 1;
    }

    private long[] getLenArr(int[] arr) {
        long[] result = new long[arr.length];
        result[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] + arr[i];
        }

        return result;
    }

    private long[] getBaseLenSum(int[] arr, int len) {
        int baseLen = 0;
        long baseSum = 0;
        int idx = 0;

        while (baseLen < len) {
            int mul = Math.min((len - baseLen), arr[idx]);
            baseSum += (long) arr[idx] * mul;

            baseLen += mul;
            idx++;
        }

        return new long[]{baseLen, baseSum, idx - 1};
    }

    public static void main(String[] args) {
        ArrayOfSquareCnt task = new ArrayOfSquareCnt();

        int[] arr = {2, 2, 2};
        int l = 2, r = 2;

        /* 2 2, 2 2, 2 2 */

//        int[] arr = {3, 2, 3, 1, 1};
//        int l = 5, r = 7;

        /* 333 22 333 1 1*/

//        int[] arr = {8, 8, 6, 5, 2, 9, 8, 4, 3, 10};
//        int l = 25, r = 27;

//        int[] arr = {49134, 86806, 94548, 88849, 95022, 28334, 16637, 79487, 23773, 7314, 47370, 50269, 36573, 9415, 44674, 28096};
//        int l = 61242, r = 88535;

        System.out.println(Arrays.toString(task.solution(arr, l, r)));
    }
}