package programmers.intro.ranking;

// 등수 매기기

// 영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다.
// 영어 점수와 수학 점수를 담은 2차원 정수 배열 score가 주어질 때,
// 영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return하도록 solution 함수를 완성해주세요.

// 0 ≤ score[0], score[1] ≤ 100
// 1 ≤ score의 길이 ≤ 10
// score의 원소 길이는 2입니다.
// score는 중복된 원소를 갖지 않습니다.

import java.util.*;

public class Ranking {

    public int[] solution(int[][] score) {
        int size = score.length;
        int[] answer = new int[size];
        double[] avg = new double[size];

        for(int i = 0; i < size; i++){
            avg[i] = (score[i][0] + score[i][1]) / 2.0;
        }

        Double[] sorted = Arrays.stream(avg).boxed().toArray(Double[]::new);
        Arrays.sort(sorted, Comparator.reverseOrder());

        Map<Double, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for(Double key : sorted){
            if(!rankMap.containsKey(key)) {
                rankMap.put(key, rank);
            }
            rank++;
        }

        for(int i = 0; i < size; i++){
            answer[i] = rankMap.get(avg[i]);
        }

        return answer;
    }

    public int[] solution2(int[][] score) {
        List<Integer> scoreList = new ArrayList<>();
        for(int[] t : score){
            scoreList.add(t[0] + t[1]);
        }
        scoreList.sort(Comparator.reverseOrder());

        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            answer[i] = scoreList.indexOf(score[i][0] + score[i][1])+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Ranking task = new Ranking();
        int[][] score = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};

        System.out.println(Arrays.toString(task.solution(score)));
    }

}
