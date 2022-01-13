package study_of_hell.백준.JSH.Silver.tier3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2805_나무_자르기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;   // 나무의 수
    static int m;   // 집으로 가져가려고 하는 나무의 길이
    static int[] nList;

    static void input(){
        n=scan.nextInt();
        m=scan.nextInt();
        nList = new int[n];
        for (int i = 0; i < n; i++) {
            nList[i] = scan.nextInt();
        }
    }

    static boolean determination(long length){
        long sum=0;
        for (int i = 0; i < n; i++) {
            if(nList[i]>length) sum+=nList[i]-length;
        }

        return sum>=m;
    }

    static void pro(){
        long ans=0;
        long l = 0, r=1000000000;
        while(l<=r){
            long mid = (l+r)/2;
            if(determination(mid)){
                ans=mid;
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
