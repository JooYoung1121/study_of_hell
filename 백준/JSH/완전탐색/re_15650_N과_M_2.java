package study_of_hell.백준.JSH.완전탐색;

import java.io.*;
import java.util.StringTokenizer;

public class re_15650_N과_M_2 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int n;
    static int m;
    static int[] adj;

    static void input(){
        n= scan.nextInt();
        m = scan.nextInt();
        adj = new int[m+1];
    }

    static void recFunc(int k){

    }

    static void pro(){
        recFunc(1);
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
