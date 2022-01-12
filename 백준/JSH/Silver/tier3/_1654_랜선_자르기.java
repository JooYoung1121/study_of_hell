package study_of_hell.백준.JSH.Silver.tier3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1654_랜선_자르기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int k;   // 이미 가지고 있는 랜선 갯수  1<=k<=10,000
    static int n;   // 필요한 랜선의 갯수         1<=n<=1,000,000
    static int[] kList;

    static void input(){
        k = scan.nextInt();
        n = scan.nextInt();
        kList = new int[k];
        for (int i = 0; i < k; i++) {
            kList[i] = scan.nextInt();
        }
    }

    static boolean canGet(long length){
        int count=0;
        for (int i = 0; i < k; i++) {
            count+=kList[i]/length;
        }

        return count>=n ? true: false;
    }

    static void pro(){
        long l=1, r=Integer.MAX_VALUE;
        long ans=0;
        while(l<=r){
            long mid = (l+r)/2;

            if(canGet(mid)){
                if(ans<mid){
                    ans=mid;
                }
                l=mid+1;
            }else{
                r=mid-1;
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
