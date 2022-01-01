package study_of_hell.백준.JSH.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _13702_이상한_술집 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;   // 주전자의 갯수
    static int k;   // 친구들의수
    static int[] adj;

    static void input(){
        n=scan.nextInt();
        k=scan.nextInt();
        adj = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            adj[i] = scan.nextInt();
        }
    }

    static boolean canDrink(long mid){
        if(mid==0) return false;
        long count=0;
        for (int i = 1; i <= n ; i++) {
            count+=adj[i]/mid;
        }

        return count>=k;
    }

    static void pro(){
        long l=0, r= Integer.MAX_VALUE, answer=0;

        while(l<=r){
            long mid = (l+r)/2;

            if(canDrink(mid)){
                answer=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        System.out.println(answer);
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
