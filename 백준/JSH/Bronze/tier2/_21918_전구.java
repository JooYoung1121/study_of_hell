package study_of_hell.백준.JSH.Bronze.tier2;

import java.io.*;
import java.util.StringTokenizer;

public class _21918_전구 {


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int[] nList;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        nList = new int[n+1];
        for (int i = 1; i <= n; i++) {
            nList[i] = scan.nextInt();
        }
    }

    static void process(int a, int b, int c) {
        switch(a) {
            case 1: nList[b] = c; break;
            case 2: for (int i = b; i <= c ; i++) nList[i] = (nList[i] == 1 ) ? 0 : 1 ; break;
            case 3: for (int i = b; i <= c ; i++) nList[i] = 0; break;
            case 4: for (int i = b; i <= c ; i++) nList[i] = 1; break;
        }
    }

    static void pro(){
        while(m-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            process(a, b, c);
        }

        for (int i = 1; i <= n ; i++) {
            sb.append(nList[i]).append(" ");
        }
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
