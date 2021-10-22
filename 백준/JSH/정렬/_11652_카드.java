package study_of_hell.백준.JSH.정렬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11652_카드 {
    static StringBuilder sb = new StringBuilder();

    static void input(){
        FastReader scan = new FastReader();
        N= scan.nextInt();
        a = new long[N+1];
        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextLong();
        }

    }

    static int N;
    static long[] a;

    static void pro(){
        // 기준을 통해 정렬하기
        Arrays.sort(a, 1, N+1);

        // mode: 최빈값, modeCnt: 최빈값의 등장 횟수, curCnt: 현재 값(a[1])의 등장 횟수
        long mode = a[1];
        int modeCnt = 1, curCnt = 1;

        // TODO
        // 2번 원소부터 차례대로 보면서, 같은 숫자가 이어서 나오고 있는 지, 새로운 숫자가 나왔는지를 판단하여 curCnt 갱신, 최빈값 갱신신
        for (int i = 2; i <=N; i++) {
            if(a[i]==a[i-1])
                curCnt++;
            else
                curCnt =1;

            if(modeCnt < curCnt){
                modeCnt = curCnt;
                mode = a[i];
            }
        }

        System.out.println(mode);
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
