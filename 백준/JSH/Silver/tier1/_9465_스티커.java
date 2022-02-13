package study_of_hell.백준.JSH.Silver.tier1;

import java.io.*;
import java.util.StringTokenizer;

public class _9465_스티커 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] nList;
    static int[][] Dy;

    static void input(){
        n=scan.nextInt();
        nList = new int[n][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                nList[j][i] =scan.nextInt();
            }
        }

        Dy = new int[n][3];    // 0은 둘다 x, 1은 1번떼기, 2는 2번떼기
    }

    static void preprocess(){
        Dy[0][0] = 0;
        Dy[0][1] = nList[0][0];
        Dy[0][2] = nList[0][1];

        for (int i = 1; i < n ; i++) {
            Dy[i][0] = Math.max(Math.max(Dy[i-1][0], Dy[i-1][1]), Dy[i-1][2]);
            Dy[i][1] = nList[i][0] + Math.max(Dy[i-1][0], Dy[i-1][2]);
            Dy[i][2] = nList[i][1] + Math.max(Dy[i-1][0], Dy[i-1][1]);
        }
    }

    static void pro(){
        preprocess();

        sb.append(Math.max(Math.max(Dy[n-1][0], Dy[n-1][1]), Dy[n-1][2])).append("\n");
    }

    public static void main(String[] args) {
        int test = scan.nextInt();

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
