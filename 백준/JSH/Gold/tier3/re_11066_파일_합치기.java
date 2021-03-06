package study_of_hell.백준.JSH.Gold.tier3;

import study_of_hell.백준.JSH.template;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class re_11066_파일_합치기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
    }

    static void pro(){
    }

    public static void main(String[] args) {
        int test = scan.nextInt();

        while(test-- > 0){
            input();
            pro();
        }
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
