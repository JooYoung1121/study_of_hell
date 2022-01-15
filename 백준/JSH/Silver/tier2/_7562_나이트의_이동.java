package study_of_hell.백준.JSH.Silver.tier2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562_나이트의_이동 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int i;
    static int[][] dir = {{2, -1}, {1, -2}, {2, 1}, {1, 2}, {-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}};
    static int[][] dist;

    static void input(){
        i=scan.nextInt();
        dist = new int[i][i];
    }

    static void bfs(int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);

        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                dist[j][k]=-1;
            }
        }

        dist[x][y]=0;

        while(!queue.isEmpty()){
            int a = queue.poll();
            int b = queue.poll();
            for (int j = 0; j < dir.length; j++) {
                int ax = a+dir[j][0];
                int by = b+dir[j][1];

                if(ax<0||by<0||ax>=i||by>=i) continue;
                if(dist[ax][by]!=-1) continue;
                dist[ax][by] = dist[a][b]+1;
                queue.add(ax);
                queue.add(by);
            }
        }
    }

    static void pro(){
        int curX = scan.nextInt();
        int curY = scan.nextInt();
        bfs(curX, curY);

        int destinationX = scan.nextInt();
        int destinationY = scan.nextInt();

        sb.append(dist[destinationX][destinationY]).append("\n");
    }

    public static void main(String[] args) {
        int test = scan.nextInt();

        while(test-->0){
            input();
            pro();
        }

        System.out.println(sb.toString());
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
