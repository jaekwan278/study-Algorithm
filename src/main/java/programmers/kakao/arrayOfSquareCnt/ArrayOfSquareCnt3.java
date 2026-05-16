//package programmers.kakao.arrayOfSquareCnt;
//
//import java.util.*;
//
//class ArrayOfSquareCnt3  {
//    public long[] solution(int[] arr, long l, long r) {
//        long[] answer = {0, 0};
//        long[] newArr = new long[0];
//        int i1 = 0;
//
//        long sum = 0;
//        long tmp = l;
//        int check1 = arr[0];
//        while (tmp > check1) {
//            tmp -= arr[i1++];
//            check1 = arr[i1];
//        }
//
//        int c1 = 0;
//        if (tmp == check1) {
//            check1 = arr[i1];
//            c1 = 1;
//        } else {
//            c1 = (int) (check1 - tmp + 1);
//        }
//
//        sum += (long) c1 * check1;
//
//        if (r > l) {
//            tmp = r;
//            int i2 = 0;
//            int check2 = arr[0];
//            while (tmp > check2) {
//                tmp -= arr[i2++];
//                check2 = arr[i2];
//            }
//
//            int c2 = (int) tmp;
//            if (tmp > 0 && tmp == arr[i2]) {
//                c2 = arr[i2];
//            }
//
//
//            if (i1 == i2) {
//                sum = sum - (long) check2 * (check2 - c2);
//                int count = 0;
//                for (int i = 0; i < arr.length; i++) {
//                    if (arr[i] == arr[i1]) {
//                        count += check2 - (c1 - check2 + c2) + 1;
//                    }
//                }
//                answer[1] = count;
//            } else {
//                sum += (long) c2 * check2;
//                for (int i = i1 + 1; i < i2; i++) {
//                    sum += (long) arr[i] * (long) arr[i];
//                }
//
//
//                int count = 0;
//
//                int checksum = 0;
//
//                for (int i = 0; i < arr.length; i++) {
//                    if ((arr[i] == arr[i1] && i + i2 - i1 < arr.length && arr[i + i2 - i1] == arr[i2])
//                            || (arr[i] == arr[i2] && i + i2 - i1 < arr.length && arr[i + i2 - i1] == arr[i1])
//                    ) {
//                        if (i2 - i1 == 1) {
//                            count++;
//                        } else {
//                            Map<Integer, Integer> map = new HashMap<>();
//                            for (int k = i1 + 1; k < i2; k++) {
//                                if (map.containsKey(arr[k])) {
//                                    map.put(arr[k], map.get(arr[k]) + 1);
//                                } else {
//                                    map.put(arr[k], 1);
//                                }
//                            }
//
//                            boolean flag = false;
//                            for (int j = i + 1; j < i + i2 - i1; j++) {
//                                if (map.containsKey(arr[j])) {
//                                    map.put(arr[j], map.get(arr[j]) - 1);
//                                    if (map.get(arr[j]) == 0) {
//                                        map.remove(arr[j]);
//                                    }
//                                } else {
//                                    break;
//                                }
//                            }
//                            if (map.isEmpty()) {
//                                flag = true;
//                            }
//                            if (flag) {
//                                count++;
//                            }
//                        }
//                    }
//                }
//                answer[1] = count;
//            }
//        } else {
//            for (int i = 0; i < arr.length; i++) {
//                answer[1] += arr[i];
//            }
//        }
//
//        answer[0] = sum;
//        System.out.println(answer[0] + "," + answer[1]);
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        ArrayOfSquareCnt3 task = new ArrayOfSquareCnt3();
//
//        int[] arr = {10, 5, 3, 1};
//        int l = 3, r = 3;
//
//        System.out.println(Arrays.toString(task.solution(arr, l, r)));
//    }
//}