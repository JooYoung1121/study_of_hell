package study_of_hell.백준.JSH.Silver.tier1;

import java.io.*;
import java.util.StringTokenizer;

public class _2688_줄어들지_않아 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static long[][] dy;

    static void input(){
        dy = new long[64+1][10];
    }

    static void preprocess(){
        //init
        for (int i = 0; i <= 9 ; i++) {
            dy[1][i] = 1;
        }

        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9 ; j++) {
                dy[i][j] = 0;
                int idx = j;
                while(idx >= 0){
                    dy[i][j] += dy[i-1][idx];
                    idx--;
                }
            }
        }


    }

    static void pro(){
        preprocess();

        int test = scan.nextInt();
        while(test-- > 0){
            int t = scan.nextInt();

            long ans = 0;
            for (int i = 0; i <= 9; i++) {
                ans += dy[t][i];
            }
            sb.append(ans).append("\n");
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
