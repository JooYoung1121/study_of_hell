package study_of_hell.백준.JSH.Silver.tier4;

import java.io.*;
import java.util.*;

public class _15970_화살표_그리기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        n = scan.nextInt();
        pointList = new Point[n];
        for (int i = 0; i < n; i++) {
            int point = scan.nextInt();
            int color = scan.nextInt();
            Point p = new Point();
            p.point = point;
            p.color = color;
            pointList[i] = p;
        }
    }

    static int n;
    static Point[] pointList;

    static class Point implements Comparable<Point> {
        int point;
        int color;

        public Point(){

        }

        @Override
        public int compareTo(Point o) {
            return this.point - o.point;
        }
    }

    static int getLeft(Point p, int idx){
        for (int i = idx-1; i >= 0 ; i--) {
            if(pointList[i].color == p.color){
                return Math.abs(pointList[i].point - p.point);
            }
        }

        return Integer.MAX_VALUE;
    }

    static int getRight(Point p, int idx){
        for (int i = idx+1; i < n ; i++) {
            if(pointList[i].color == p.color){
                return Math.abs(pointList[i].point - p.point);
            }
        }

        return Integer.MAX_VALUE;
    }


    static void pro(){
        Arrays.sort(pointList);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            Point point = pointList[i];
            int left = getLeft(point, i);
            int right = getRight(point, i);
            sum += Math.min(left, right);
        }

        sb.append(sum);
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
