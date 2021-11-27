package study_of_hell.백준.JSH.그래프;

import java.io.*;
import java.util.StringTokenizer;

public class _4963_섬의_개수 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int w;   // 지도의 너비
    static int h;   // 지도의 높이
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static int count;

    static void input(){
        map = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                map[i][j]=scan.nextInt();
            }
        }
        visit = new boolean[w][h];
    }

    static void dfs(int x, int y){
        visit[x][y]= true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx<0 || ny<0 || nx>=w || ny>=h) continue;
            if(visit[nx][ny]) continue;
            if(map[nx][ny]==0) continue;
            dfs(nx, ny);
        }

    }

    static void pro(){
        count=0;

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if(!visit[i][j]&&map[i][j]==1) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        sb.append(count+"\n");
    }

    public static void main(String[] args) {
        while(true){
            w = scan.nextInt();
            h = scan.nextInt();
            if(w==0 && h==0) break;
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
