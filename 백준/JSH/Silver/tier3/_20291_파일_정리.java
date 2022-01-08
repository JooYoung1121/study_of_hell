package study_of_hell.백준.JSH.Silver.tier3;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _20291_파일_정리 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static HashMap<String, Integer> map;

    static void input(){
        map = new HashMap<>();
        int x = scan.nextInt();
        for (int i = 0; i < x; i++) {
            String dx = scan.nextLine();
            String ext = dx.split("\\.")[1];
            map.put(ext, map.getOrDefault(ext, 0)+1);
        }
    }

    static void pro(){
        String[] keys = map.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        for (String key: keys) {
            sb.append(key + " "+map.get(key)+"\n");
        }

    }

    public static void main(String[] args) {
        input();
        pro();
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
