package study_of_hell.백준.JSH.Silver.tier2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15663_N과_M_9 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int[] nList;
    static int count;
    static int[] ans;
    static boolean[] used;

    static void input(){
        n=scan.nextInt();
        m=scan.nextInt();
        nList = new int[n];
        for (int i = 0; i < n; i++) {
            nList[i] = scan.nextInt();
        }
        ans = new int[m];
        used = new boolean[n];
    }

    static void recFunc(int k){
        if(count==m){
            for (int i = 0; i < m; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
        }else{
            int lastCand =0;
            for (int i = 0; i <n ; i++) {
                if(used[i]) continue;
                if(lastCand==nList[i]) continue;
                lastCand=nList[i];
                ans[count++]=nList[i]; used[i]=true;
                recFunc(k+1);
                ans[--count]=-1; used[i]=false;
            }
        }

    }

    static void pro(){
        count=0;
        Arrays.sort(nList);
        recFunc(0);

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
