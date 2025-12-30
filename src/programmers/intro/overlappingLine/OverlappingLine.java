package programmers.intro.overlappingLine;

// 겹치는 선분의 길이

// 선분 3개가 평행하게 놓여 있습니다.
// 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때,
// 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.

public class OverlappingLine {

    public int solution(int[][] lines) {
        int answer = 0;

        int min = Math.min(Math.min(lines[0][0], lines[1][0]), lines[2][0]);
        int max = Math.max(Math.max(lines[0][1], lines[1][1]), lines[2][1]);

        for(int i = min; i <= max; i++){
            int isOL = 0;
            if((lines[0][0] <= i) && (i + 1 <= lines[0][1])){
                isOL++;
            }
            if((lines[1][0] <= i) && (i + 1 <= lines[1][1])){
                isOL++;
            }
            if((lines[2][0] <= i) && (i + 1 <= lines[2][1])){
                isOL++;
            }
            if(isOL >= 2){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        OverlappingLine task = new OverlappingLine();
        int[][] lines = {{0, 1}, {2, 5}, {3, 9}};

        System.out.println(task.solution(lines));
    }

}
