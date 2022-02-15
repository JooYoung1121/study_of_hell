package study_of_hell.백준.JSH.Silver.tier1;

import java.io.*;
import java.util.StringTokenizer;

public class _11052_카드_구매하기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] Dy;
    static int[] pList;

    static void input(){
        n=scan.nextInt();
        pList = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            pList[i] = scan.nextInt();
        }
        Dy = new int[n+1];
    }

    static void preprocess(){
        Dy[1] = pList[1];

        for (int i = 2; i <=n ; i++) {
            int max = pList[i];
            for (int j = 1; j <=i ; j++) {
                int a = i-j;
                max = Math.max(max,Dy[a]+Dy[j]);
            }
            Dy[i] = max;
        }

    }

    static void pro(){
        preprocess();
        System.out.println(Dy[n]);
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
