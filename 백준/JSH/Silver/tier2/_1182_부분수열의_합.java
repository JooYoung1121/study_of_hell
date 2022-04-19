package study_of_hell.백준.JSH.Silver.tier2;

import java.io.*;
import java.util.StringTokenizer;

public class _1182_부분수열의_합 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = scan.nextInt();
        S = scan.nextInt();
        nList = new int[N];
        for (int i = 0; i < N; i++) {
            nList[i] = scan.nextInt();
        }
    }

    static int S;
    static int N;
    static int[] nList;
    static int[] temp;
    static int ans;

    public static void recFunc(int count, int cur, int k){
        if(k == count){
            int sum = 0;
            for (int j : temp) {
                sum += j;
            }
            if(sum == S) ans++;
        }else{
            for (int i = cur; i < nList.length; i++) {
                temp[k] = nList[i];
                recFunc(count, i+1, k+1);
                temp[k] = -1;
            }
        }

    }

    public static void main(String[] args) {
        input();
        ans = 0;
        for (int i = 1; i <= N ; i++) {
            temp = new int[i];
            recFunc(i, 0, 0);
        }

        System.out.println(ans);
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
