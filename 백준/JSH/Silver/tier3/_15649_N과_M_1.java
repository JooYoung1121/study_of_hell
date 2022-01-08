package study_of_hell.백준.JSH.Silver.tier3;

import java.io.*;
import java.util.StringTokenizer;

public class _15649_N과_M_1 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();
    
    static int n;
    static int m;
    static int[] selected;
    static boolean[] visit;
    
    static void input(){
        n= scan.nextInt();
        m = scan.nextInt();
        selected  = new int[m+1];
        visit = new boolean[n+1];
    }
    
    static void recFunc(int k){
        if(k==m+1){
            for (int i = 1; i <=m ; i++) sb.append(selected[i]+" ");
            sb.append("\n");
        }else{
            for (int i = 1; i <=n ; i++) {
                if(visit[i]) continue;
                selected[k]= i;
                visit[i]= true;
                recFunc(k+1);
                selected[k] = -1;
                visit[i]=false;
            }
        }
    }
    
    static void pro(){
        recFunc(1);
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
