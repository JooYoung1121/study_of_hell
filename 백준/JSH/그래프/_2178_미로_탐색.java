package study_of_hell.백준.JSH.그래프;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178_미로_탐색 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static String[] adj;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] dist;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        adj = new String[n+1];
        for (int i = 1; i <=n ; i++) {
            adj[i]=scan.nextLine();
        }
        visit = new boolean[n+1][m+1];
        dist = new int[n+1][m+1];
    }

    static void bfs(int startX, int startY){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                dist[i][j]=-1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);
        visit[startX][startY] = true;
        dist[startX][startY] =1;

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x+dir[i][0];
                int ny = y+dir[i][1];

                if(nx<1 || ny<1 || nx>n || ny > m) continue;
                if(visit[nx][ny]) continue;
                if(adj[nx].charAt(ny-1)!='1') continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y]+1;
            }
        }
    }

    static void pro(){
        bfs(1, 1);
        System.out.println(dist[n][m]);
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
