package study_of_hell.백준.JSH.Silver.tier4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1764_듣보잡 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;   // 듣도 못한 사람
    static int m;   // 보도 못한 사람
    static String[] nList;
    static String[] mList;
    static ArrayList<String> answers;

    static void input(){
        n=scan.nextInt();
        m=scan.nextInt();
        nList = new String[n+1];
        mList = new String[m+1];
        for (int i = 1; i <=n ; i++) {
            nList[i] = scan.next();
        }
        for (int i = 1; i <=m ; i++) {
            mList[i] = scan.next();
        }
        answers=new ArrayList<>();
    }

    static boolean binarySearch(String ch, int l, int r){

        while(l<=r){
            int mid = (l+r)/2;

            if(mList[mid].equals(ch)) return true;

            if(mList[mid].compareTo(ch) < 0) l=mid+1;
            else r=mid-1;
        }

        return false;
    }

    static void pro(){
        // 정렬
        Arrays.sort(nList, 1, n+1);
        Arrays.sort(mList, 1, m+1);

        for (int i = 1; i <= n; i++) {
            if(binarySearch(nList[i], 1, m)) answers.add(nList[i]);
        }

        sb.append(answers.size()+"\n");
        for (String answer: answers) {
            sb.append(answer+"\n");
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
