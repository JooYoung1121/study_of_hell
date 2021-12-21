package study_of_hell.백준.JSH.완전탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class re_3584_가장_가까운_공통_조상 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int node;
    static HashMap<Integer, Integer> map;
    static int a;
    static int b;
    static ArrayList<Integer> aParents;
    static ArrayList<Integer> bParents;

    static void input(){
        node= scan.nextInt();
        map = new HashMap<>();
        for (int i = 0; i < node-1; i++) {
            int parent = scan.nextInt();
            int child = scan.nextInt();
            map.put(child, parent);
        }
        a = scan.nextInt();
        b = scan.nextInt();
        aParents = new ArrayList<>();
        bParents = new ArrayList<>();
    }

    // 부모 반환, 없으면 -1 반환
    static void getParent(int child, ArrayList<Integer> parents){
        if(!map.containsKey(child)) return;
        else {
            int parent = map.get(child);
            parents.add(parent);
            getParent(parent, parents);
        }
    }

    static void pro(){
        aParents.add(a);
        bParents.add(b);
        getParent(a, aParents);
        getParent(b, bParents);

        int distance = Integer.MAX_VALUE;
        int answer=0;
        for (int i = 0; i < aParents.size(); i++) {
            for (int j = 0; j < bParents.size(); j++) {
                if(aParents.get(i)==bParents.get(j)){
                    if(distance>i+j) {
                        distance = i+j;
                        answer=aParents.get(i);
                    }
                }
            }
        }

        sb.append(answer+"\n");
    }

    public static void main(String[] args) {
        int testCase = scan.nextInt();

        for (int i = 0; i < testCase; i++) {
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
