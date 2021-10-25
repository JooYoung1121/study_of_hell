package study_of_hell.백준.JSH.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2470_두_용액 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static int N;
    static int[] A;


    static int lower_bound(int[] A, int L, int R, int X){
        // A[L...R] 에서 X미만의 수(X보다 작은 수) 중 제일 오른 쪽 인덱스를 return 하는 함수
        // 그런게 없다면 L-1 return
        int res = R + 1;  // 만약 A[L...R] 중
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] >= X) {
                res = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return res;
    }

    static void pro(){
        // A 에 대해 이분 탐색을 할 예정이니까, 정렬을 미리 해주자.
        Arrays.sort(A, 1, N + 1);

        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for (int left = 1; left <= N - 1; left++) {
            // A[left] 용액을 쓸 것이다. 고로 -A[left] 와 가장 가까운 용액을 자신의 오른쪽 구간에서 찾자.
            int candidate = lower_bound(A, left + 1, N, -A[left]);

            // A[candidate - 1] 와 A[candidate] 중에 A[left] 와 섞었을 때의 정보를 정답에 갱신시킨다.

            // 1. A[left] + A[candidate - 1]
            if (left < candidate - 1 && Math.abs(A[left] + A[candidate - 1]) < best_sum) {
                best_sum = Math.abs(A[left] + A[candidate - 1]);
                v1 = A[left];
                v2 = A[candidate - 1];
            }

            // 2. A[left] + A[candidate]
            if (candidate <= N && Math.abs(A[left] + A[candidate]) < best_sum) {
                best_sum = Math.abs(A[left] + A[candidate]);
                v1 = A[left];
                v2 = A[candidate];
            }

        }
        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
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
