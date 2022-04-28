package study_of_hell.백준.JSH.Silver.tier1;


import java.io.*;
import java.util.StringTokenizer;

public class _11057_오르막_수 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        n = scan.nextInt();
        dy = new int[n+1][10];
    }

    static int n;
    static int[][] dy;

    static void preprocess(){
        //init
        for (int i = 0; i <= 9; i++) {
            dy[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10 ; j++) {
                for (int k = 0; k <= j; k++) {
                    dy[i][j] += dy[i-1][k];
                    dy[i][j] = (dy[i][j])%10007;
                }
            }
        }
    }

    static void pro(){
        preprocess();

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dy[n][i];
            ans = ans %10007;
        }

        System.out.println(ans);
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
