package study_of_hell.백준.JSH.Silver.tier4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17266_어두운_굴다리 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int[] xList;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        xList = new int[m+1];
        for (int i = 1; i <= m; i++) {
            xList[i] = scan.nextInt();
        }
    }

    static boolean check(int height) {
        int last = 0;  // 밝혀진 마지막 위치
        for (int i = 1; i <= m; i++) {
            if (xList[i] - last <= height) {
                last = xList[i] + height;
            } else {
                return false;
            }
        }
        return last >= n;
    }


    static void pro(){

        int ans = n;
        int left = 0, right = n;

        Arrays.sort(xList, 1, m + 1);

        while(left <= right){
            int mid = (left+right)/2;

            if(check(mid)){
                right = mid - 1;
                ans = mid;
            }else{
                left = mid + 1;
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
