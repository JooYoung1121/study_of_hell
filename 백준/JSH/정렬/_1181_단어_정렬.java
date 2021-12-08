package study_of_hell.백준.JSH.정렬;

import java.io.*;
import java.util.*;

public class _1181_단어_정렬 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;   // 단어의 갯수
    static Elem[] arr;

    static void input(){
        n = scan.nextInt();
        arr = new Elem[n];
        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();
            arr[i] = new Elem();
            arr[i].word = word;
        }
    }

    static class Elem implements Comparable<Elem>{
        public String word;

        @Override
        public int compareTo(Elem o) {
            if(word.length()<o.word.length())
                return -1;
            else if(word.length()>o.word.length())
                return 1;
            else return word.compareTo(o.word);
        }
    }

    static void pro(){
        Arrays.sort(arr);
        List<String> elemList = new ArrayList<>();


        for (Elem word: arr) {
            if(!elemList.contains(word.word)){
                elemList.add(word.word);
                sb.append(word.word +"\n");
            }
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
