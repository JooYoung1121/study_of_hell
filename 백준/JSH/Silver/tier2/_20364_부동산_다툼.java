package study_of_hell.백준.JSH.Silver.tier2;

import java.io.*;
import java.util.*;

public class _20364_부동산_다툼 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        n = scan.nextInt();
        q = scan.nextInt();
        qList = new int[q];
        for (int i = 0; i < q; i++) {
            qList[i] = scan.nextInt();
        }
        nList = new boolean[n+1];
    }

    static int n;
    static int q;
    static int[] qList;
    static boolean[] nList;

    static List<Integer> getList(int duck){
        List<Integer> list = new ArrayList<>();

        while(duck != 1){
            list.add(duck);
            duck = duck % 2 == 0 ? duck / 2 : (duck - 1)/2;
        }

        Collections.reverse(list);
        return list;
    }

    static void pro(){
        for (int duck: qList){
            List<Integer> parentList = getList(duck);

            boolean check = false;
            int temp = 0;
            for(int parent : parentList){
                if(nList[parent]){
                    check = true; temp = parent;
                    break;
                }
            }
            if(!check) nList[duck] = true;

            sb.append(temp).append("\n");
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
