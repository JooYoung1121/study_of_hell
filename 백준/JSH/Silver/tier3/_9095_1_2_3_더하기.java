package study_of_hell.백준.JSH.Silver.tier3;

import java.io.*;
import java.util.StringTokenizer;

public class _9095_1_2_3_더하기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] dy = new int[12];

    static void input(){
        n= scan.nextInt();
    }

    static void preprocess(){
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        for (int i = 4; i <= 11 ; i++) {
            dy[i] = dy[i-3] + dy[i-2] + dy[i-1];
        }
    }

    static void pro(){
        sb.append(dy[n]).append("\n");
    }

    public static void main(String[] args) {
        int test = scan.nextInt();
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
