package programmers.intro.parallel;

// 평행


public class Parallel {

    public int solution(int[][] dots) {
        return (
                isParallel(dots[0], dots[1], dots[2], dots[3])
                        || isParallel(dots[0], dots[2], dots[1], dots[3])
                        || isParallel(dots[0], dots[3], dots[1], dots[2])
        ) ? 1 : 0;
    }

    public static boolean isParallel(int[] a1, int[] a2, int[] b1, int[] b2) {
        return ((a1[0] - a2[0]) * (b1[1] - b2[1])) == ((a1[1] - a2[1]) * (b1[0] - b2[0]));
    }

    public static void main(String[] args) {
        Parallel task = new Parallel();
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        int[][] dots2 = {{3, 5}, {4, 1}, {2, 4}, {5, 10}};

        System.out.println(task.solution(dots2));
    }

}
