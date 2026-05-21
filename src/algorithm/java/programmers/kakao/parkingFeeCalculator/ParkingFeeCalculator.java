package programmers.kakao.parkingFeeCalculator;

// 주차 요금 계산

import utils.Compare;

import java.util.*;

public class ParkingFeeCalculator {

    private int feeCalc(int useTime, int baseT, int baseF, int unitT, int unitF){

        if(useTime <= baseT) return baseF;

        useTime -= baseT;
        int extra = (int)Math.ceil((double)useTime / unitT) * unitF;

        return baseF + extra;
    }

    // 기존
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> result = new TreeMap<>();

        for(String record : records){
            String[] cur = record.split(" ");
            String[] timeStr = cur[0].split(":");

            int time = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);

            if(cur[2].equals("IN")){
                map.put(cur[1], time);
            }else{
                result.put(cur[1], result.getOrDefault(cur[1], 0) + time - map.remove(cur[1]));
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + (1439 - entry.getValue()));
        }

        int[] answer = new int[result.size()];

        int idx = 0;
        for(Map.Entry<String, Integer> entry : result.entrySet()){
            answer[idx++] = feeCalc(entry.getValue(), fees[0], fees[1], fees[2], fees[3]);
        }

        return answer;
    }

    // split -> substring
    public int[] solution2(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> result = new TreeMap<>();

        for(String record : records){
            String timeStr = record.substring(0, 5);
            String car = record.substring(6, 10);
            String type = record.substring(11);

            int hour = Integer.parseInt(timeStr.substring(0, 2));
            int minute = Integer.parseInt(timeStr.substring(3));

            int time = hour * 60 + minute;

            if(type.equals("IN")){
                map.put(car, time);
            }else{
                result.put(car, result.getOrDefault(car, 0) + (time - map.remove(car)));
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + (1439 - entry.getValue()));
        }

        int[] answer = new int[result.size()];

        int idx = 0;
        for(Map.Entry<String, Integer> entry : result.entrySet()){
            answer[idx++] = feeCalc(entry.getValue(), fees[0], fees[1], fees[2], fees[3]);
        }

        return answer;
    }

    // split -> substring + TreeMap -> HashMap, List
    public int[] solution3(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();

        for(String record : records){
            String timeStr = record.substring(0, 5);
            String car = record.substring(6, 10);
            String type = record.substring(11);

            int hour = Integer.parseInt(timeStr.substring(0, 2));
            int minute = Integer.parseInt(timeStr.substring(3));

            int time = hour * 60 + minute;

            if(type.equals("IN")){
                map.put(car, time);
            }else{
                result.put(car, result.getOrDefault(car, 0) + (time - map.remove(car)));
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + (1439 - entry.getValue()));
        }

        List<String> keyList = new ArrayList<>(result.keySet());
        Collections.sort(keyList);

        int[] answer = new int[result.size()];

        int idx = 0;
        for(String car : keyList){
            answer[idx++] = feeCalc(result.get(car), fees[0], fees[1], fees[2], fees[3]);
        }

        return answer;
    }

    public static void main(String[] args) {
        ParkingFeeCalculator task = new ParkingFeeCalculator();

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(task.solution3(fees, records)));

        Compare.measureTime(()->task.solution2(fees, records), ()->task.solution3(fees, records));
    }

}
