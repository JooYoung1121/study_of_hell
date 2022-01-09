package study_of_hell.백준.JSH.Silver.tier4;

import java.io.*;
import java.util.*;

public class _2667_단지_번호_붙이기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static String[] adj;    // 1은 집이 있는 곳, 0은 집이 없는 곳
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] group;
    static ArrayList<Integer> answer;
    static int groupCnt;

    static void input(){
        n=scan.nextInt();
        adj = new String[n];
        for (int i = 0; i < n; i++) {
            adj[i] = scan.next();
        }
        group = new boolean[n][n];
        answer = new ArrayList<>();
    }

    static void dfs(int x, int y){
        groupCnt++;
        group[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int ax = x + dir[i][0];
            int by = y + dir[i][1];
            if(ax<0 || by<0 || ax >=n || by >=n) continue;
            if(adj[ax].charAt(by)=='0') continue;
            if(group[ax][by]) continue;
            dfs(ax, by);
        }
    }

    static void pro(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(adj[i].charAt(j)=='0') continue; // 집이 아니라면 continue
                if(group[i][j]) continue;    // 이미 그룹에 속한 집이라면 continue
                groupCnt=0;
                dfs(i, j);
                answer.add(groupCnt);
            }
        }

        sb.append(answer.size()+"\n");
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)+"\n");
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
