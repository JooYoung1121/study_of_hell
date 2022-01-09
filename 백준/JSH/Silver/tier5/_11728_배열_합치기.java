package study_of_hell.백준.JSH.Silver.tier5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11728_배열_합치기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int[] adj;

    static void input(){
        n=scan.nextInt();
        m=scan.nextInt();
        adj= new int[n+m];
        for (int i = 0; i < n+m; i++) {
            adj[i] = scan.nextInt();
        }
    }

    static void pro(){
        Arrays.sort(adj);

        for (int i = 0; i < n+m; i++) {
            sb.append(adj[i]+" ");
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
