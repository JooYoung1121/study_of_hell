package study_of_hell.백준.JSH.그래프;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2606_바이러스 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int a;
    static int[][] adj;
    static boolean[] visit;
    static int answer;

    static void input(){
        n=scan.nextInt();
        a=scan.nextInt();
        adj = new int[n+1][n+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                adj[i][j]=0;
            }
        }
        for (int i = 0; i < a; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x][y] =1;
            adj[y][x]=1;
        }
        visit = new boolean[n+1];
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()){
            int x = queue.poll();

            for (int i = 1; i <=n ; i++) {
                if(adj[x][i]==0) continue;
                if(visit[i]) continue;
                queue.add(i);
                answer++;
                visit[i]=true;
            }
        }
    }

    static void pro(){
        answer=0;
        bfs(1);
        sb.append(answer);
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
