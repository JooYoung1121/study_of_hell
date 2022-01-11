package study_of_hell.백준.JSH.Silver.tier4;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _10816_숫자_카드_2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;

    static HashMap<Integer, Integer> hashMap;

    static void input(){
        n=scan.nextInt();
        hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            hashMap.put(a, hashMap.getOrDefault(a, 0)+1);
        }
        m=scan.nextInt();
    }

    static void pro(){
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            sb.append(hashMap.getOrDefault(a, 0)).append(" ");
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
