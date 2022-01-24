package study_of_hell.백준.JSH.Silver.tier2;

import java.io.*;
import java.util.StringTokenizer;

public class _15988_1_2_3_더하기_3 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long[] Dy;

    static void input(){
        n=scan.nextInt();
    }

    static void preprocess(){
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        for (int i = 4; i <=1000000 ; i++) {
            Dy[i] = (Dy[i - 1] + Dy[i - 2] + Dy[i - 3])%1000000009;
        }
    }

    static void pro(){
        sb.append(Dy[n]).append("\n");
    }

    public static void main(String[] args) {
        int test = scan.nextInt();

        Dy = new long[1000000+1];
        preprocess();

        while(test-->0){
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
