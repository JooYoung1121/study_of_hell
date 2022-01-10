package study_of_hell.백준.JSH.Silver.tier4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920_수_찾기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] aList;
    static int m;
    static int[] mList;

    static void input(){
        n=scan.nextInt();
        aList = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            aList[i] = scan.nextInt();
        }
        m= scan.nextInt();
        mList = new int[m];
        for (int i = 0; i < m; i++) {
            mList[i] = scan.nextInt();
        }
    }

    static boolean binarySearch(int x, int l, int r){
        while(l<=r){
            int mid = (l+r)/2;

            if(aList[mid]==x) return true;

            if(aList[mid]>x){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return false;
    }


    static void pro(){
        //aList 정렬
        Arrays.sort(aList, 1, n+1);

        for (int i = 0; i < m; i++) {
            int x = mList[i];
            if(binarySearch(x, 1, n)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
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
