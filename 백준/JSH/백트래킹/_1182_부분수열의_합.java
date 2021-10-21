package study_of_hell.백준.JSH.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class _1182_부분수열의_합 {
    static StringBuilder sb = new StringBuilder();

    static void input(){
        FastReader scan = new FastReader();
        N= scan.nextInt();
        S= scan.nextInt();
        nums = new int[N+1];
        for (int i = 1; i <=N ; i++) nums[i] = scan.nextInt();
    }

    static int N, S, ans;
    static int[] nums;

    // k번째 원소를 포함시킬지 정하는 함수
    // value:=k-1 번째 원소까지 골라진 원소들의 합
    static void rec_func(int k, int value){
        if(k==N+1){
            //value가 S랑 같은지 확인
            if(value==S) ans++;
        }else{
            // k 번째 원소를 포함시킬지 결정하고 재귀호출
            rec_func(k+1, value+nums[k]);
            rec_func(k+1, value);
        }
    }

    public static void main(String[] args) {
        input();

        rec_func(1, 0);
        if(S==0){
            ans--;
        }
        System.out.println(ans);
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
