package study_of_hell.백준.JSH.Silver.tier1;

import java.io.*;
import java.util.*;

public class _1697_숨바꼭질 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        n = scan.nextInt();
        k = scan.nextInt();
        dist = new int[100000+1];
    }

    static int n;
    static int k;
    static int[] dist;

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        dist[x] = 0;

        while(!queue.isEmpty()){
            int a = queue.poll();

            for (int i = 0; i < 3; i++) {
                int b;
                if(i == 0){
                    b = a - 1;
                } else if(i == 1){
                    b = a + 1;
                } else{
                    b = a * 2;
                }
                if(b < 0 || b > 100000) continue;
                if(dist[b] != 0) continue;  // 이미 갔던 점이라면
                dist[b] = dist[a] + 1;
                queue.add(b);
            }
        }
    }

    static void pro() {
        if(n == k){
            System.out.println(0);
        }else{
            bfs(n);
            System.out.println(dist[k]);
        }
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
