package study_of_hell.백준.JSH.Silver.tier1;

import java.io.*;
import java.util.*;

public class _1389_케빈_베이컨의_6단계_법칙 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int[] dist;
    static HashMap<Integer, ArrayList> map;

    static void input(){
        n=scan.nextInt();
        m=scan.nextInt();
        map = new HashMap<>();
        dist = new int[n+1];

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            ArrayList aList = map.getOrDefault(a, new ArrayList());
            aList.add(b);
            ArrayList bList = map.getOrDefault(b, new ArrayList());
            bList.add(a);

            map.put(a, aList);
            map.put(b, bList);
        }

    }

    static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while(!queue.isEmpty()){
            int a = queue.poll();
            ArrayList<Integer> list = map.get(a);

            for (int i = 0; i < list.size(); i++) {
                int people = list.get(i);
                if(dist[people]!=0) continue;   //이미 방문한 사람이면
                dist[people] = dist[a]+1;
                queue.add(people);
            }
        }
    }

    static void pro(){
        int minIdx = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 1; i <=n ; i++) {
            bfs(i);
            int sum = 0;
            for (int j = 1; j <=n ; j++) {
                if(i==j) continue;
                sum+=dist[j];
            }
            if(sum<minValue) {
                minIdx = i;
                minValue = sum;
            }
            dist = new int[n+1];
        }

        System.out.println(minIdx);
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
