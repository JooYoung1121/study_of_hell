package study_of_hell.백준.JSH.Silver.tier1;
import java.io.*;
import java.util.StringTokenizer;

public class _2343_기타_레슨 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        nList = new int[n];
        for (int i = 0; i < n; i++) {
            nList[i] = scan.nextInt();
        }
    }

    static int n;
    static int m;
    static int[] nList;

    static boolean check(int l){
        int count = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(sum + nList[i] > l){
                sum = nList[i];
                count++;
            }else{
                sum += nList[i];
            }
        }

        return count <= m;
    }

    static void pro(){
        int l = 1, r = 1000000000;
        for (int i = 0; i < n; i++) l = Math.max(l, nList[i]);
        int ans = 1;

        while(l <= r){
            int mid = (l + r)/2;
            if(check(mid)){
                r = mid - 1;
                ans = mid;
            }else{
                l = mid + 1;
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
