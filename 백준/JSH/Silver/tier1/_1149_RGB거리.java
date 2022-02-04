package study_of_hell.백준.JSH.Silver.tier1;
import java.io.*;
import java.util.StringTokenizer;

public class _1149_RGB거리 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] dy;
    static int[][] nList;

    static void input(){
        n=scan.nextInt();
        dy = new int[n+1][3];
        // 0-> 빨강
        // 1-> 초록
        // 2-> 파랑
        nList = new int[n+1][3];
        for (int i = 1; i <=n ; i++) {
            nList[i][0]=scan.nextInt();
            nList[i][1]=scan.nextInt();
            nList[i][2]=scan.nextInt();
        }
    }

    static void preprocess(){
        dy[1][0] = nList[1][0];  // 마지막이 빨강인 경우
        dy[1][1] = nList[1][1];  // 마지막이 빨강인 경우
        dy[1][2] = nList[1][2];  // 마지막이 빨강인 경우

        for (int i = 2; i <=n ; i++) {
            dy[i][0]=Math.min(dy[i-1][1], dy[i-1][2])  + nList[i][0];
            dy[i][1]=Math.min(dy[i-1][0], dy[i-1][2])  + nList[i][1];
            dy[i][2]=Math.min(dy[i-1][1], dy[i-1][0])  + nList[i][2];
        }
    }

    static void pro(){
        preprocess();

        int minPrice = Math.min(Math.min(dy[n][0], dy[n][1]),dy[n][2]);
        System.out.println(minPrice);
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
