package study_of_hell.백준.JSH.기타;

import java.io.*;
import java.util.StringTokenizer;

public class _1929_소수_구하기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int m;
    static int n;
    static boolean[] adj;

    static void input(){
        m = scan.nextInt();
        n = scan.nextInt();
        adj = new boolean[n+1];
    }

    // false: 소수, true: 소수아님
    static void getPrime(){
        adj[0]=true;
        adj[1]=true;

        for (int i = 2; i <=n; i++) {
            if(adj[i]) continue;
            for (int j = i+i; j <= n; j+=i) {
                adj[j] = true;
            }
        }
    }

    static void pro(){
        getPrime();

        for (int i = m; i <=n ; i++) {
            if(!adj[i]) sb.append(i+"\n");
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
