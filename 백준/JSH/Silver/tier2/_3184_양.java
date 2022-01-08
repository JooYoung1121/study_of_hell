package study_of_hell.백준.JSH.Silver.tier2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _3184_양 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int r;   // 행
    static int c;   // 열
    static String[] adj;
    static boolean[][] visit;
    static int sheep;
    static int wolf;
    static int allSheep;
    static int allWolf;
    static int[][] dir = {{1,0}, {-1,0}, {0, 1}, {0, -1}};

    static void input(){
        r= scan.nextInt();
        c = scan.nextInt();
        adj = new String[r];
        for (int i = 0; i < r; i++) {
            adj[i] = scan.nextLine();
        }
        visit = new boolean[r][c];
    }

    static void dfs(int x, int y){
        if(adj[x].charAt(y)=='o') sheep++;
        else if(adj[x].charAt(y)=='v') wolf++;
        visit[x][y]=true;

        for (int i = 0; i < 4; i++) {
            int nx = x+dir[i][0];
            int ny = y+dir[i][1];
            if(nx<0||ny<0||nx>=r||ny>=c) continue;
            if(adj[nx].charAt(ny)=='#') continue;
            if(visit[nx][ny]) continue;

            dfs(nx, ny);

        }

    }

    static void pro(){
        allSheep = 0;
        allWolf = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(adj[i].charAt(j)=='.'||adj[i].charAt(j)=='#') continue;
                if(visit[i][j]) continue;

                // 늑대나 양이고, 방문하지 않았다면
                dfs(i, j);
                if(sheep>wolf) allSheep+=sheep;
                else allWolf +=wolf;
                sheep=0;
                wolf=0;
            }
        }

        System.out.println(allSheep + " " +allWolf);
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
