package study_of_hell.백준.JSH.트리;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class re_1991_트리_순회 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static HashMap<Character, Node> nodes;

    public static class Node{
        char left;
        char right;

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static void input(){
        n=scan.nextInt();
        nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node();
            char name = scan.next().charAt(0);
            node.left = scan.next().charAt(0);
            node.right = scan.next().charAt(0);
            nodes.put(name, node);
        }
    }

    // 전위 순회: 루트->왼쪽->오른쪽
    static void preOrder(char ch){
        if(ch=='.') return;
        Node node = nodes.get(ch);
        sb.append(ch);  // 루트
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위 순회: 왼쪽->루트->오른쪽
    static void inOrder(char ch){
        if(ch=='.') return;
        Node node = nodes.get(ch);
        inOrder(node.left);
        sb.append(ch);
        inOrder(node.right);
    }

    // 후위 순회: 왼쪽->오른쪽->루트
    static void postOrder(char ch){
        if(ch=='.') return;
        Node node = nodes.get(ch);
        postOrder(node.left);
        postOrder(node.right);
        sb.append(ch);
    }


    static void pro(){
        preOrder('A');
        sb.append("\n");
        inOrder('A');
        sb.append("\n");
        postOrder('A');
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
