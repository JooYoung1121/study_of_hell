package study_of_hell.백준.JSH.Silver.tier2;

import java.io.*;
import java.util.StringTokenizer;

public class _11724_연결_요소의_개수 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static boolean[] visit;
    static int[][] adj;
    static int answer;

    static void input(){
        n=scan.nextInt();
        m=scan.nextInt();
        visit = new boolean[n+1];
        adj = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    static void dfs(int x){
        visit[x]=true;

        for (int i = 1; i < n+1; i++) {
            if(x==i) continue;
            if(adj[x][i]==0)continue;
            if(visit[i]) continue;

            dfs(i);
        }
    }

    static void pro(){
        for (int i = 1; i < n+1; i++) {
            if(visit[i]) continue;
            dfs(i);
            answer++;
        }

        System.out.println(answer);
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
