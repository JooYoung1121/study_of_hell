package study_of_hell.백준.JSH.Silver.tier1;

import java.io.*;
import java.util.StringTokenizer;

public class _2156_포도주_시식 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        n = scan.nextInt();
        nList = new int[n];
        for (int i = 0; i < n; i++) {
            nList[i] = scan.nextInt();
        }
        dy = new int[n][2];
    }

    static int n;
    static int[] nList;
    static int[][] dy;

    static void preprocess(){
        // init
        dy[0][1] = nList[0];

        dy[1][0] = Math.max(dy[0][0], dy[0][1]);
        dy[1][1] = Math.max(dy[0][0], dy[0][1]) + nList[1];

        for (int i = 2; i < n; i++) {
            dy[i][0] = Math.max(dy[i-1][0], dy[i-1][1]);
            dy[i][1] = Math.max(dy[i-2][0] + nList[i-1], dy[i-1][0]) + nList[i];
        }

    }

    static void pro(){
        if(n == 1){
            System.out.println(nList[0]);
        }else{
            preprocess();
            int ans = Math.max(dy[n-1][0], dy[n-1][1]);
            System.out.println(ans);
        }
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
