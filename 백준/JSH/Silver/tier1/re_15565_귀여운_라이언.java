package study_of_hell.백준.JSH.Silver.tier1;

import java.io.*;
import java.util.StringTokenizer;

public class re_15565_귀여운_라이언 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        n = scan.nextInt();
        k = scan.nextInt();
        nList = new int[n];
        for (int i = 0; i < n; i++) {
            nList[i] = scan.nextInt();
        }
    }

    static int n;
    static int k;
    static int[] nList;

    static void pro(){

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
