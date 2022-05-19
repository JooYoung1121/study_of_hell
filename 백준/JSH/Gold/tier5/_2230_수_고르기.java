package study_of_hell.백준.JSH.Gold.tier5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2230_수_고르기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int[] nList;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        nList = new int[n];
        for (int i = 0; i < n; i++) {
            nList[i] = scan.nextInt();
        }
    }

    static void pro(){
        Arrays.sort(nList);

        int idx = 0;
        int ans = Integer.MAX_VALUE;
        while(idx < n-1){
            int minNum = nList[idx] + m;
            for (int i = idx+1; i < n; i++) {
                if(nList[i] >= minNum) {
                    ans = Math.min(ans, nList[i] - nList[idx]);
                    break;
                }
            }
            idx++;
        }

        System.out.println(ans);

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
