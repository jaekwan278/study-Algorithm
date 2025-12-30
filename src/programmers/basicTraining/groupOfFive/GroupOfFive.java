package programmers.basicTraining.groupOfFive;

// 5명씩

import utils.Compare;

public class GroupOfFive {

    public String[] solution(String[] names) {
        int length = names.length;
        String[] answer = new String[ (length + 4) / 5];

        int cnt = 0;
        while(length > cnt){
            answer[cnt / 5] = names[cnt];
            cnt += 5;
        }

        return answer;
    }

    public String[] solution2(String[] names) {
        int groupCount = (names.length + 4) / 5; // 올림 계산
        String[] representatives = new String[groupCount];

        for (int i = 0; i < groupCount; i++) {
            int firstIndex = i * 5;
            representatives[i] = names[firstIndex];
        }

        return representatives;
    }

    public static void main(String[] args) {
        GroupOfFive task = new GroupOfFive();
        String[] names = {"nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"};

//        System.out.println(Arrays.toString(task.solution(names)));

        Compare.measureTime(() -> task.solution(names), () -> task.solution2(names));
    }

}
