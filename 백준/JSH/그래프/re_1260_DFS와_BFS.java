package study_of_hell.백준.JSH.그래프;

import java.util.*;

public class re_1260_DFS와_BFS {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        N = sc.nextInt();   // 정점의 갯수
        M = sc.nextInt();   // 간선의 갯수
        V = sc.nextInt();   // 탐색을 시작할 정점의 번호 V
        adj = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x][y] = adj[y][x] = 1;
        }
    }

    // x 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');

        for (int y = 1; y <=N ; y++) {
            if(adj[x][y]==0) continue;

            if(visit[y]) continue;

            dfs(y);
        }
    }

    // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = true;

        while(!que.isEmpty()){
            int x = que.poll();

            sb.append(x).append(' ');
            for (int y = 1; y <=N ; y++) {
                if(adj[x][y]==0) continue;
                if(visit[y]) continue;

                que.add(y);
                visit[y]=true;
            }
        }

    }

    static void pro() {
        visit = new boolean[N+1];
        dfs(V);
        sb.append('\n');
        for (int i = 1; i <=N ; i++) visit[i] =false;
        bfs(V);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
