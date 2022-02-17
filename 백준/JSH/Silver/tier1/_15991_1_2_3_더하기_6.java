package study_of_hell.백준.JSH.Silver.tier1;

import java.io.*;
import java.util.StringTokenizer;

public class _15991_1_2_3_더하기_6 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long[] Dy = new long[100000+1];
    static int MOD = 1000000009;

    static void input(){
        n=scan.nextInt();
    }

    static void preprocess(){
        Dy[0] = 1;
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 2;

        for (int i = 4; i <= 100000 ; i++) {
            Dy[i] = (Dy[i-2]+Dy[i-4]+(i>=6 ? Dy[i-6] : 0))%MOD;
        }
    }

    static void pro(){
        sb.append(Dy[n]).append("\n");
    }

    public static void main(String[] args) {
        preprocess();
        int test = scan.nextInt();

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
