package study_of_hell.백준.JSH.Silver.tier2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11725_트리의_부모_찾기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static ArrayList<Integer>[] adj;
    static int[] parents;
    static boolean[] visit;

    static void input(){
        n=scan.nextInt();
        adj = new ArrayList[n+1];
        for (int i = 1; i <=n ; i++) {
            adj[i]=new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        parents = new int[n+1];
        visit = new boolean[n+1];
    }

    static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visit[x]=true;

        while(!queue.isEmpty()){
            int a = queue.poll();
            for (int i = 0; i < adj[a].size(); i++) {
                if(visit[adj[a].get(i)]) continue;

                parents[adj[a].get(i)]=a;
                visit[adj[a].get(i)]=true;
                queue.add(adj[a].get(i));
            }
        }

    }

    static void pro(){
        bfs(1);

        for (int i = 2; i <=n; i++) {
            sb.append(parents[i]).append("\n");
        }
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
