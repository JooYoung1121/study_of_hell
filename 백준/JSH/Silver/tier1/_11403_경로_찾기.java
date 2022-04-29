package study_of_hell.백준.JSH.Silver.tier1;

import java.io.*;
import java.util.*;

public class _11403_경로_찾기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        n = scan.nextInt();
        nList = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nList[i][j] = scan.nextInt();
            }
        }
        check = new boolean[n];
    }

    static int n;
    static int[][] nList;
    static boolean[] check;

    static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i< n; i++){
            if(nList[x][i] == 0) continue;
            if(i == x) continue;
            queue.add(i);
            check[i] = true;
        }

        while(!queue.isEmpty()){
            int a = queue.poll();
            for (int i = 0; i < n; i++) {
                if(check[i]) continue;  // 이미 갔다면 pass
                if(nList[a][i] == 0) continue;  //갈 수 없으면 pass
                queue.add(i);
                check[i] = true;
            }
        }
    }

    static void pro(){

        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            check = new boolean[n];
            bfs(i);
            for (int j = 0; j < n; j++) {
                sb.append(check[j] ? 1 : 0).append(" ");
            }
            sb.append("\n");
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
