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

        int leftIdx = 0;
        int rightIdx = 0;

        long curIdx = 0;
        long curSum = 0;

        // initial value setting
        while(curIdx < len){
            if(curIdx >= lenArr[rightIdx]) rightIdx++;

            long move = Math.min((len - curIdx), (lenArr[rightIdx] - curIdx));

            if(move <= 0) break;

            curIdx += move;
            curSum += arr[rightIdx] * move;
        }

        while(curIdx <= lenArr[lenArr.length-1]){
            // value
            long offset = arr[rightIdx] - arr[leftIdx];
            curSum += offset;
            long diff = target - curSum;

            // length
            long leftStart = (leftIdx == 0 ? 1 : lenArr[leftIdx - 1] + 1);

            int leftOff = (int)((curIdx - len) - leftStart + 1);
            int rightOff = (int)(lenArr[rightIdx] - curIdx);

            int move = Math.min(leftOff, rightOff);

            if(move <= 0) break;

            // verify
            result += isVerifySubArr(diff, offset, move);

            // increase
            curIdx += move;
            curSum += (offset * (move - 1));

            if(lenArr[rightIdx] < curIdx) rightIdx++;
            if(lenArr[leftIdx] < (curIdx - len)) leftIdx++;

        }

        return result;
    }

    // 333 22 333 1 1
    // subarray verification process
    private long isVerifySubArr(long diff, long offset, int move){

        if(offset == 0 && diff != 0){
//            System.out.println("case 1");
            return 0;
        }

        if(diff == 0){
            if(offset == 0){
//                System.out.println("case 2");
                return move;
            }

            else{
//                System.out.println("case 3");
                return 1;
            }
        }

        if((diff < 0 && offset > 0) || (diff > 0) && offset < 0){

            if((diff % offset == 0) && (Math.abs(diff) / Math.abs(offset) <= move)){
//                System.out.println("case 4");
                return 1;
            }

        }

//        System.out.println("case 0");
        return 0;
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
//        int[] arr = {8, 8, 6, 5, 2, 9, 8, 4, 3, 10};
//        int l = 25, r = 27;
//
//        int[] arr = {70195, 25471, 7389, 58187, 18454, 90532, 97667, 17148, 91636, 2810};
//        int l = 126058, r = 462933;

//        int[] arr = {16952, 70276, 16771, 37992, 87549, 54906, 36718, 20478, 57088, 27916, 51509, 83422, 51707, 18807, 80859, 2673, 37734, 93380};
//        int l = 149845, r = 228204;

        int[] arr = {70195, 25471, 7389, 58187, 18454, 90532, 97667, 17148, 91636, 2810};
        int l = 126058, r = 462933;

        System.out.println(Arrays.toString(task.solution(arr, l, r)));
    }

}
