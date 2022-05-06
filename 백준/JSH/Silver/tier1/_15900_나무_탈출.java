package study_of_hell.백준.JSH.Silver.tier1;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _15900_나무_탈출 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        n = scan.nextInt();
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        dist = new int[n+1];
    }

    static int n;
    static ArrayList<Integer>[] list;
    static int ans;
    static int[] dist;

    static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        dist[x] = 1;

        while(!queue.isEmpty()){
            int a = queue.poll();

            if(list[a].size() == 1 && a != 1){    // 리프 노드라면
                ans += dist[a]-1;
            }else{
                for(int b : list[a]){
                    if(dist[b] != 0) continue;  // 이미 갔던 점이라면
                    queue.add(b);
                    dist[b] = dist[a] + 1;
                }
            }
        }

    }

    static void pro(){
        ans = 0;

        bfs(1);

        if(ans % 2 == 0) sb.append("No");
        else sb.append("Yes");

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
