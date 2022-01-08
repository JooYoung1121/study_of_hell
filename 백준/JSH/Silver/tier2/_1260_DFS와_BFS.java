package study_of_hell.백준.JSH.Silver.tier2;

import java.io.*;
import java.util.*;

public class _1260_DFS와_BFS {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;   // 정점의 갯수
    static int m;   // 간선의 갯수
    static int v;   // 정점의 번호
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        v = scan.nextInt();
        adj = new int[n+1][n+1];
        visit = new boolean[n+1];
        for (int i = 1; i<=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                adj[i][j]=0;
            }
        }
        for (int i = 1; i <= m ; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            adj[a][b] = 1;
            adj[b][a] = 1;
        }
    }

    // x 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x) {
        sb.append(x+" ");
        visit[x] = true;

        for (int i = 1; i <= n ; i++) {
            if(visit[i]) continue;
            if(adj[x][i]!=1) continue;
            dfs(i);
        }
    }

    // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        sb.append(start+" ");

        while(!queue.isEmpty()){
            int x = queue.poll();

            for (int i = 1; i <= n ; i++) {
                if(visit[i]) continue;
                if(adj[x][i]!=1) continue;
                sb.append(i + " ");
                visit[i] = true;
                queue.add(i);
            }
        }
    }

    static void pro() {
        // dfs
        dfs(v);

        sb.append("\n");
        visit = new boolean[n+1];

        // bfs
        bfs(v);

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
