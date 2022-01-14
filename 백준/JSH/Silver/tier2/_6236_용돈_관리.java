package study_of_hell.백준.JSH.Silver.tier2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _6236_용돈_관리 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int[] nList;

    static void input(){
        n=scan.nextInt();
        m=scan.nextInt();
        nList = new int[n];
        for (int i = 0; i < n; i++) {
            nList[i]=scan.nextInt();
        }
    }

    static boolean determination(long money){
        int count=0;
        long leftMoney=0;
        for (int i =0; i < n; i++) {
            if(leftMoney<nList[i]){
                count++;
                leftMoney=money-nList[i];
            }else{
                leftMoney-=nList[i];
            }
        }

        return count<=m;
    }

    static void pro(){
        long ans=0;
        long l= Arrays.stream(nList).max().getAsInt(), r=1000000000;

        while(l<=r){
            long mid = (l+r)/2;
            if(determination(mid)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
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
