package study_of_hell.백준.JSH.그래프;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1012_유기농_배추 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int M; // 배추밭의 가로길이
    static int N; // 배추밭의 세로길이
    static int K; // 배추가 심어져 있는 위치의 갯수
    static int[][] a;
    static int[][] cabbage;
    static boolean[][] visit;
    static int count;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input(){
        M=scan.nextInt();
        N=scan.nextInt();
        K=scan.nextInt();
        a = new int[M][N];
        cabbage = new int[K][2];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] =0;
            }
        }
        for (int i = 0; i < K; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            cabbage[i][0]=x;
            cabbage[i][1]=y;
            a[x][y] = 1;
        }
        visit = new boolean[M][N];
    }

    static void dfs(int x, int y){
        visit[x][y]=true;

        for (int i = 0; i < 4; i++) {
            int nx = x+ dir[i][0];
            int ny = y+dir[i][1];

            if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
            if(visit[nx][ny]) continue;
            if(a[nx][ny]==0) continue;
            dfs(nx, ny);
        }
    }

    static void pro(){
        count=0;
        for (int i = 0; i < K; i++) {
            int x = cabbage[i][0];
            int y = cabbage[i][1];
            if(!visit[x][y]&&a[x][y]==1){
                count++;
                dfs(x, y);
            }
        }
        sb.append(count + "\n");
    }

    public static void main(String[] args) {
        int testCount = scan.nextInt();
        for (int i = 0; i < testCount; i++) {
            input();
            pro();
        }

        System.out.println(sb.toString());
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
