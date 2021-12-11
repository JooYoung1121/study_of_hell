package study_of_hell.백준.JSH.그래프;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5567_결혼식 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int[][] adj;
    static int[] visit;
    static int count;

    static void input(){
        n=scan.nextInt();
        m=scan.nextInt();
        adj = new int[n+1][n+1];
        visit = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                adj[i][j]=0;
            }
            visit[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            adj[a][b]=1;
            adj[b][a]=1;
        }
    }

    static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visit[x]=0;

        while(!queue.isEmpty()){
            int go = queue.poll();
            for (int i = 1; i <=n; i++) {
                if(adj[go][i]!=1) continue;
                if(visit[i]!=-1) continue;
                visit[i]=visit[go]+1;
                if(visit[i]==1 || visit[i]==2) {
                    count++;
                    queue.add(i);
                }
            }
        }
    }

    static void pro(){
        count=0;
        bfs(1);
        sb.append(count);
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
