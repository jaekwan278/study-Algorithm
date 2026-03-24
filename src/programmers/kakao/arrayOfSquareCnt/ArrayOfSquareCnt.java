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



        return answer;
    }

    public static void main(String[] args) {
        ArrayOfSquareCnt task = new ArrayOfSquareCnt();

//        int[] arr = {3, 2, 3, 1, 1};
//        int l = 5, r = 7;

//        int[] arr = {8, 8, 6, 5, 2, 9, 8, 4, 3, 10};
//        int l = 25, r = 27;

        int[] arr = {49134, 86806, 94548, 88849, 95022, 28334, 16637, 79487, 23773, 7314, 47370, 50269, 36573, 9415, 44674, 28096};
        int l = 61242, r = 88535;

        System.out.println(Arrays.toString(task.solution(arr, l, r)));
    }
}
