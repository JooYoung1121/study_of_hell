package study_of_hell.백준.JSH.Silver.tier3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _7795_먹을_것인가_먹힐_것인가 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int a;
    static int b;
    static int[] aList;
    static int[] bList;
    static int answer;

    static void input() {
        a= scan.nextInt();
        b=scan.nextInt();
        aList = new int[a];
        bList = new int[b];
        for (int i = 0; i < a; i++) {
            aList[i]=scan.nextInt();
        }
        for (int i = 0; i < b; i++) {
            bList[i]=scan.nextInt();
        }
    }

    static void pro(){
        Arrays.sort(aList);
        Arrays.sort(bList);

        answer=0;
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                if(bList[i]<aList[j]){
                    answer+=a-j;
                    break;
                }
            }
        }

        sb.append(answer+"\n");
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
