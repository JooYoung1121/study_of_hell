package study_of_hell.백준.JSH.Silver.tier3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3273_두_수의_합 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] adj;
    static int x;
    static boolean[] visit;

    static void input(){
        n=scan.nextInt();
        adj= new int[n+1];
        for (int i = 1; i <=n ; i++) {
            adj[i] = scan.nextInt();
        }
        x=scan.nextInt();
        visit = new boolean[n+1];
    }

    static int binarySearch(int x, int l, int r){
        while(l<=r){
            int mid = (l+r)/2;
            if(adj[mid]==x) return mid;

            if(adj[mid]<x) l=mid+1;
            else r=mid-1;
        }

        return -1;
    }

    static void pro(){
        Arrays.sort(adj, 1, n+1);

        int ans =0;
        for (int i = 1; i <=n; i++) {
            int a = x-adj[i];
            if(visit[i]) continue;
            if(a<1) continue;   // 음수면 pass
            int idx = binarySearch(a, i+1 ,n);
            if(idx==-1) continue;
            else{
                visit[i]=true; visit[idx]=true;
                ans++;
            }
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
