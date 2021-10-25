package study_of_hell.백준.JSH.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _7795_먹을_것인가_먹힐_것인가 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 1; i <= M; i++) {
            B[i] = scan.nextInt();
        }
    }

    static int N, M;
    static int[] A, B;

    static int lower_bound(int[] A, int L, int R, int X){
        // A[L...R] 에서 X미만의 수(X보다 작은 수) 중 제일 오른 쪽 인덱스를 return 하는 함수
        // 그런게 없다면 L-1 return
        int res = L - 1;  // 만약 A[L...R] 중 X 이하의 수가 없다면 L - 1 을 return 한다.
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] < X) {
                res = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return res;
    }

    static void pro(){
        // B 배열에 대해 이분탐색을 할 예정이니까, 정렬 해주자!
        Arrays.sort(B, 1, M+1);

        int ans = 0;
        for (int i = 1; i <= N ; i++) {
            // A[i]를 선택했을 때, B에서는 A[i]보다 작은 게 몇 개나 있는지 카운트 하기
            ans += lower_bound(B, 1, M, A[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int TT;
        TT = scan.nextInt();
        for (int tt = 1; tt <= TT; tt++) {
            input();
            pro();
        }
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
