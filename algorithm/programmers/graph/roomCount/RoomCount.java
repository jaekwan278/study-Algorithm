package programmers.graph.roomCount;

// 방의 개수

/*

    방의 조건 :
        왔던 좌표 다시 옴 ?
        방향 전환 발생시의 좌표 저장 ? 꼭짓점 ?

    대각선 처리 : 좌표 2배 확장

    방향 전환점 ( 꼭짓점 ) 기준 그래프 - 그래프 연결된 노드 저장
    DFS 연결된 노드 탐색 -> 꼭짓점으로 다시 되돌아옴 ? -> 도형 인식++

    꼭짓점 사이의 간선을 통과할 경우는 ?
        간선 따로 저장 ?

    !! 이미 지나왔던 점에 새로운 방향의 간선이 도착하면 도형
        간선 = 양방향
 */

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RoomCount {

    private static int[] xDir = {0, 2, 2, 2, 0, -2, -2, -2};
    private static int[] yDir = {2, 2, 0, -2, -2, -2, 0, 2};

//    record Point(int x, int y){};
//    record Edge(Point from, Point to){
//        Edge{
//            if( from.x() > to.x()
//                || (from.x() == to.x() && from.y() > to.y())){
//                Point tmp = from;
//                from = to;
//                to = tmp;
//            }
//        }
//    }

    private static class Point {
        int x, y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
//            final int prime = 31;
//            int result = 1;
//            result = prime * result + x;
//            result = prime * result + y;
//            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Point)) return false;
            Point p = (Point) obj;
            return p.x == x && p.y == y;
        }
    }

    private static class Edge {
        final Point p1;
        final Point p2;

        private Edge(Point p1, Point p2){
            if( p1.x > p2.x
                || (p1.x == p2.x && p1.y > p2.y)){

                Point tmp = p1;
                p1 = p2;
                p2 = tmp;
            }

            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(p1, p2);
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(!(obj instanceof Edge)) return false;
            Edge e = (Edge) obj;
            return e.p1.equals(p1) && e.p2.equals(p2);
        }
    }

    public int solution(int[] arrows) {

        Set<Point> pointSet = new HashSet<>();
        Set<Edge> edgeSet = new HashSet<>();

        return move(pointSet, edgeSet, arrows, 0, 0);
    }

    private int move(Set<Point> pSet, Set<Edge> eSet, int[] arrows, int x, int y) {
        int result = 0;

        Point from;
        Point to = new Point(x, y);
        pSet.add(to);

        for (int ar : arrows) {

            for (int i = 0; i < 2; i++) {
                x += xDir[ar] / 2;
                y += yDir[ar] / 2;

                from = to;
                to = new Point(x, y);

                Edge line = new Edge(from, to);

                if (pSet.contains(to) && !eSet.contains(line)) result++;

                pSet.add(to);

                eSet.add(line);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        RoomCount task = new RoomCount();
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};

        System.out.println(task.solution(arrows));
    }

}
