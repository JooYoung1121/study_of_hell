package study_of_hell.백준.JSH.Silver.tier3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2512_예산 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;   // 지방의 수
    static int[] nList;
    static int m;   // 총 예산

    static void input(){
        n=scan.nextInt();
        nList = new int[n];
        for (int i = 0; i < n; i++) {
            nList[i]=scan.nextInt();
        }
        m=scan.nextInt();
    }

    static boolean canGo(int price){
        int sum =0;
        for (int i = 0; i < n; i++) {
            sum+= nList[i] > price ? price : nList[i];
        }

        return sum<=m;
    }

    static void pro(){
        int ans=0;
        int l = 0, r= Arrays.stream(nList).max().getAsInt();

        while(l<=r){
            int mid = (l+r)/2;

            if(canGo(mid)){
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
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
