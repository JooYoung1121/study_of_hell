package study_of_hell.백준.JSH.Silver.tier3;

import java.io.*;
import java.util.StringTokenizer;

public class _2003_수들의_합_2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int[] nList;
    static int count;

    static void input(){
        n=scan.nextInt();
        m=scan.nextInt();
        nList = new int[n];
        for (int i = 0; i < n; i++) {
            nList[i]=scan.nextInt();
        }
    }


    static void pro(){
        for (int i = 0; i < n; i++) {
            int sum=0;
            int idx = i;
            while(idx<n){
                sum+=nList[idx++];
                if(sum==m) count++;
                else if(sum>m) break;
            }
        }

        System.out.println(count);
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
