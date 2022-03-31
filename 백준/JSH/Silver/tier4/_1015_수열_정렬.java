package study_of_hell.백준.JSH.Silver.tier4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1015_수열_정렬 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] A;
    static int[] ans;

    static void input(){
        n = scan.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scan.nextInt();
        }
        ans = new int[n];
    }

    static void pro(){
        int[] B = A.clone();
        Arrays.sort(B);

        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = A[i];
            for(int j = 0; j < n; j++){
                if(!check[j]&&B[j]==x){
                    ans[i] = j;
                    check[j] = true;
                    break;
                }
            }
        }

        for(int a : ans){
            sb.append(a).append(" ");
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
