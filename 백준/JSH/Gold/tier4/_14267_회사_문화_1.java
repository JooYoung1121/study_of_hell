package study_of_hell.백준.JSH.Gold.tier4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _14267_회사_문화_1 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;   // 회사의 직원 수
    static int m;   // 최초 칭찬의 횟수
    static ArrayList<Integer>[] adj;
    static int[] praiseList;

    static void input(){
        n=scan.nextInt();
        m=scan.nextInt();
        adj = new ArrayList[n+1];
        for (int i = 1; i <=n ; i++) {
            adj[i]=new ArrayList<>();
        }

        for (int i = 1; i <=n; i++) {
            int parent = scan.nextInt();
            if(parent!=-1) adj[parent].add(i);
        }
        praiseList = new int[n+1];
        for (int i=1;i<=m;i++){
            int x= scan.nextInt(), v= scan.nextInt();
            praiseList[x] += v;
        }
    }

    static void DFS(int x){
        for(int y: adj[x]){
            praiseList[y] += praiseList[x];
            DFS(y);
        }
    }

    static void pro(){
        DFS(1);

        for (int i = 1; i <=n ; i++) {
            sb.append(praiseList[i]+" ");
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
