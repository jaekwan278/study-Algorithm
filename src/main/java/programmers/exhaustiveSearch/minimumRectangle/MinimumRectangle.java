package programmers.exhaustiveSearch.minimumRectangle;

// 최소 직사각형

import utils.Compare;

import java.util.Arrays;

public class MinimumRectangle {

    public int solution(int[][] sizes) {
        int len = sizes.length;;

        int[] width = new int[len];
        int[] height = new int[len];

        for(int i = 0; i < sizes.length; i++){
            width[i] = Math.max(sizes[i][0], sizes[i][1]);
            height[i] = Math.min(sizes[i][0], sizes[i][1]);
        }

        Arrays.sort(width);
        Arrays.sort(height);

        return width[len - 1] * height[len -1];
    }

    public int solution2(int[][] sizes) {
        int width = 0, height = 0;

        for(int[] size : sizes){
            width = Math.max(width, Math.max(size[0], size[1]));
            height = Math.max(height, Math.min(size[0], size[1]));
        }

        return width * height;
    }

    public static void main(String[] args) {
        MinimumRectangle task = new MinimumRectangle();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(task.solution2(sizes));

        Compare.measureTime(()->task.solution(sizes), ()->task.solution2(sizes));
    }

}
