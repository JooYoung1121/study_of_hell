package study_of_hell.백준.JSH;

import java.io.*;
import java.util.StringTokenizer;

public class _15651_N과_M_3 {
    static StringBuilder sb = new StringBuilder();

    static void input(){
        FastReader scan = new FastReader();
        N= scan.nextInt();
        M= scan.nextInt();
        selected = new int[M+1];
    }

    static int N, M;
    static int[] selected;

    static void rec_func(){


    }

    public static void main(String[] args) {
        input();

        rec_func();

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
