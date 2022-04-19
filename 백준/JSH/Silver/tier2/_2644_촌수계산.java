package study_of_hell.백준.JSH.Silver.tier2;

import java.io.*;
import java.util.*;

public class _2644_촌수계산 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        n = scan.nextInt();
        x = scan.nextInt();
        y = scan.nextInt();
        m = scan.nextInt();
        map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int parent = scan.nextInt();
            int child = scan.nextInt();
            map.put(child, parent);
        }

    }

    static int n;
    static int x, y;
    static int m;
    static HashMap<Integer, Integer> map;

    static void pro(){
        ArrayList<Integer> xParentList = new ArrayList<>();
        ArrayList<Integer> yParentList = new ArrayList<>();
        xParentList.add(x);
        yParentList.add(y);

        int xTemp = x;
        while(map.containsKey(xTemp)){
            xParentList.add(map.get(xTemp));
            xTemp = map.get(xTemp);
        }

        int yTemp = y;
        while(map.containsKey(yTemp)){
            yParentList.add(map.get(yTemp));
            yTemp = map.get(yTemp);
        }

        int ans = -1;
        for (int i = 0; i < xParentList.size(); i++) {
            boolean check = false;
            for (int j = 0; j < yParentList.size(); j++) {
                if(Objects.equals(xParentList.get(i), yParentList.get(j))){
                    ans = i + j;
                    check = true; break;
                }
            }
            if(check) break;
        }


        System.out.println(ans);

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
