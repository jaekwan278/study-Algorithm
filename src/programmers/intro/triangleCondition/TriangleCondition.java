package programmers.intro.triangleCondition;

// 삼각형의 완성조건

// 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
// 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
// 삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 나머지 한 변
// 이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.

import java.util.Arrays;

public class TriangleCondition {

    public int solution(int[] sides) {
        int answer = 0;

        int[] arr = sides.clone();

        Arrays.sort(arr);

        int min = arr[1] - arr[0];
        int max = arr[1] + arr[0];

        answer = max - min - 1;

        return answer;
    }

    public int solution2(int[] sides) {
        int mn = Math.min(sides[0], sides[1]);
        return mn + (mn - 1);
    }

    public static void main(String[] args) {
        TriangleCondition task = new TriangleCondition();
        int[] sides = {2, 7};

        System.out.println(task.solution(sides));
    }
}
