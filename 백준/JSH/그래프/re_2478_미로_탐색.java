package study_of_hell.백준.JSH.그래프;

import java.util.LinkedList;
import java.util.Queue;

public class re_2478_미로_탐색 {
    static re_1697_숨바꼭질.FastReader sc = new re_1697_숨바꼭질.FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int M;
    static String[] adj;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] dist;

    static void input(){
        N=sc.nextInt();
        M=sc.nextInt();
        adj = new String[N];
        for (int i = 0; i < N; i++) {
            adj[i] = sc.nextLine();
        }
        visit = new boolean[N][M];
        dist  = new int[N][M];
    }

    static void bfs(int x, int y){
        // dist 배열 초기화
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) dist[i][j] = -1;

        // (x, y)를 Q에 넣어주고, visit 표시와 dist 값 초기화
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = 1;
        visit[x][y] = true;

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;  // 지도를 벗어나는 곳으로 가는가?
                if (adj[nx].charAt(ny) == '0') continue;  // 갈 수 있는 칸인지 확인해야 한다.
                if (visit[nx][ny]) continue;  // 이미 방문한 적이 있는 곳인가?
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

    }

    static void pro(){
        // 시작점이 (0,0)인 탐색 시작
        bfs(0, 0);

        // (N-1, M-1)까지 필요한 최소 이동 횟수 출력
        System.out.println(dist[N-1][M-1]);

    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
