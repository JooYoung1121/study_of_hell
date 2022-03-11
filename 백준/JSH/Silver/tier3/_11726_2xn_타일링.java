package study_of_hell.백준.JSH.Silver.tier3;

import java.io.*;
import java.util.StringTokenizer;

public class _11726_2xn_타일링 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] dy;

    static void input(){
        n=scan.nextInt();
        dy = new int[1000+1];
    }

    static void preprocess(){
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n ; i++) {
            dy[i] = (dy[i-1]+dy[i-2])%10007;
        }
    }

    static void pro(){
        preprocess();
        System.out.println(dy[n]);
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
