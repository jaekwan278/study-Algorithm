package programmers.intro.rectangleAreaCalc;

// 직사각형 넓이 구하기

// 2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다.
// 직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨있는 배열 dots가 매개변수로 주어질 때,
// 직사각형의 넓이를 return 하도록 solution 함수를 완성해보세요.

// dots의 길이 = 4
// dots의 원소의 길이 = 2
// -256 < dots[i]의 원소 < 256
// 잘못된 입력은 주어지지 않습니다.

public class RectangleAreaCalc {

    public int solution(int[][] dots) {

        int minX = dots[0][0], maxX = dots[0][0];
        int minY = dots[0][1], maxY = dots[0][1];

        for(int[] dot : dots){

            minX = Math.min(dot[0], minX);
            maxX = Math.max(dot[0], maxX);
            minY = Math.min(dot[1], minY);
            maxY = Math.max(dot[1], maxY);

        }

        return (maxX - minX) * (maxY - minY);
    }

    public static void main(String[] args) {

        RectangleAreaCalc task = new RectangleAreaCalc();
        int[][] dots = {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

        System.out.println(task.solution(dots));
    }
}
