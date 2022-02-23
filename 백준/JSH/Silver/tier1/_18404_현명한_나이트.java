package study_of_hell.백준.JSH.Silver.tier1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18404_현명한_나이트 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int x, y;
    static int[][] dist;
    static int[][] dir = {{-2,-1}, {-2,1},{-1,-2},{-1,2}, {1,-2}, {1,2}, {2,-1}, {2,1}};

    static void input(){
        n=scan.nextInt();
        m=scan.nextInt();
        x=scan.nextInt();
        y=scan.nextInt();
        dist = new int[n+1][n+1];
    }

    static void bfs(int a, int b){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        queue.add(b);

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for (int i = 0; i < dir.length; i++) {
                int ax = x+dir[i][0];
                int ay = y+dir[i][1];
                if(ax<1||ay<1||ax>n||ay>n) continue;
                if(dist[ax][ay]!=0) continue;   // 이미 간 곳
                dist[ax][ay] = dist[x][y]+1;
                queue.add(ax);
                queue.add(ay);
            }
        }

    }

    static void pro(){
        bfs(x,y);

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            sb.append(dist[a][b]).append(" ");
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
