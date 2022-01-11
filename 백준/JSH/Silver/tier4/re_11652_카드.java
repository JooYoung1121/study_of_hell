package study_of_hell.백준.JSH.Silver.tier4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class re_11652_카드 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long[] card;

    static void input(){
        n=scan.nextInt();
        card = new long[n+1];
        for (int i = 1; i <= n ; i++) {
            card[i] = scan.nextLong();
        }
    }

    static void pro(){
        Arrays.sort(card, 1, n+1);

        int count=1;
        int ans = 1;    // 갯수
        long res = card[1];       // 정답
        for (int i = 2; i <= n ; i++) {
            if(card[i-1]==card[i]){  // 첫번째 숫자가 아니면서 이전과 같은숫자면
                count++;
            }else{
                count=1;
            }

            if(count>ans){
                res = card[i];
                ans = count;
            }
        }

        System.out.println(res);
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
