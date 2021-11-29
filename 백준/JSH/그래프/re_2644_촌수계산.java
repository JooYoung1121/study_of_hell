package study_of_hell.백준.JSH.그래프;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class re_2644_촌수계산 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;   // 전체 사람의 수
    static int x, y;    // 촌수를 계산해야 하는 서로 다른 두 사람의 번호
    static int m;   // 부모 자식들 간의 관계의 개수
    static ArrayList<Integer>[] adj;
    static int[] dist;


    static void input(){
        n = scan.nextInt();
        x = scan.nextInt();
        y = scan.nextInt();
        m = scan.nextInt();
        adj= new ArrayList[n+1];
        for (int i = 1; i <=n ; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <=m ; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n ; i++) {
            dist[i]=-1;
        }

        q.add(start);
        dist[start]= 0;

        while(!q.isEmpty()){
            int x= q.poll();

            for (int y: adj[x]){
                if(dist[y]!=-1) continue;

                q.add(y);
                dist[y]= dist[x]+1;
            }
        }

    }

    static void pro(){
        dist = new int[n+1];
        bfs(x);
        System.out.println(dist[y]);
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
