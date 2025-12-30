package programmers.greedy.connectingIslands;

// 섬 연결하기

import java.util.Arrays;

/*

    1. 모든 연결 구하기
    2. 비용이 높은 연결 순으로 하나씩 제거 -> 전체 연결 확인 -> end

 */

public class ConnectingIslands {

    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int[] root = new int[n];
        for(int i = 0; i < n; i++) root[i] = i;

        int count = 0;
        for(int[] c : costs){
            int a = c[0];
            int b = c[1];
            int cost = c[2];

            if(findRoot(a, root) != findRoot(b, root)){
                union(a, b, root);
                answer += cost;
                count++;
            }

            if(count == n - 1) break;

        }


        return answer;
    }

    private static int findRoot(int n, int[] root){
        if(root[n] == n) return n;

        return root[n] = findRoot(root[n], root);
    }

    private static void union(int a, int b, int[] root){
        a = findRoot(a, root);
        b = findRoot(b, root);

        if(a != b) root[b] = a;
    }


    public int solution2(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        int cnt = 0;
        for(int[] c : costs){

            if(find(c[0], parent) != find(c[1], parent)){

                cnt++;
                answer += c[2];
            }

            if(cnt == n - 1) break;

        }

        return answer;
    }

    private static void union2(int a, int b, int[] parent){

        a = find(a, parent);
        b = find(b, parent);

        if(a != b) parent[b] = a;
    }

    private static int find(int n, int[] parent){
        if(parent[n] == n) return n;

        return parent[n] = find(parent[n], parent);
    }

    public static void main(String[] args) {
        ConnectingIslands task = new ConnectingIslands();
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        System.out.println(task.solution(n, costs));

        System.out.println(task.solution2(n, costs));
    }

}
