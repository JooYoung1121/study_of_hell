package study_of_hell.백준.JSH.완전탐색;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1759_암호_만들기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int l;
    static int c;
    static char[] adj;
    static int gather;  // 모음 갯수
    static int consonant;   // 자음 갯수
    static char[] gatherList = {'a', 'e', 'i', 'o', 'u'};   // 모음 리스트
    static char[] answer;
    static boolean[] check;

    static void input(){
        l=scan.nextInt();
        c=scan.nextInt();
        adj = new char[c+1];
        for (int i = 1; i <=c; i++) {
            adj[i]=scan.next().charAt(0);
        }
        answer = new char[l+1];
        check = new boolean[c+1];
    }

    // 모음이면 true
    static boolean isGather(char ch){
        for (int i = 0; i < gatherList.length; i++) {
            if(gatherList[i]==ch) return true;
        }
        return false;
    }

    static int getIndex(char ch){
        for (int i = 1; i <=c ; i++) {
            if(adj[i]==ch) return i;
        }
        return -1;
    }

    static void recFunc(int k){
        if(k==l+1){
            if(gather<1||consonant<2) return;
            for (int i = 1; i <=l; i++) {
                sb.append(answer[i]);
            }
            sb.append("\n");
        }else{
            int index = 1;
            if(k>=2) index = getIndex(answer[k-1]);
            for (int i = index; i <=c; i++) {
                if(check[i]) continue;
                boolean isGather = isGather(adj[i]);
                answer[k] = adj[i]; check[i]=true;
                if(isGather) gather++; else consonant++;
                recFunc(k+1);
                answer[k] = '\0'; check[i]=false;
                if(isGather) gather--; else consonant--;
            }
        }
    }

    static void pro(){
        Arrays.sort(adj);
        recFunc(1);
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
