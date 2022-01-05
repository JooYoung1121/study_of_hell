package study_of_hell.백준.JSH.DP;


import java.io.*;
import java.util.StringTokenizer;

public class _10870_피보나치_수_5 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] dy;

    static void input(){
        dy = new int[21];
    }

    static void preDp(){
        // 초기화
        dy[0] =0;
        dy[1] = 1;

        for (int i = 2; i < 21; i++) {
            dy[i] = dy[i-1]+dy[i-2];
        }
    }

    static void pro(){
        preDp();

        int n = scan.nextInt();
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
