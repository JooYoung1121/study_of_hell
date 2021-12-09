package study_of_hell.백준.JSH.정렬;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _10825_국영수 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static Student[] students;

    static void input(){
        n = scan.nextInt();
        students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student();
            students[i].name = scan.next();
            students[i].korean = scan.nextInt();
            students[i].english = scan.nextInt();
            students[i].math = scan.nextInt();
        }
    }

    static class Student implements Comparable<Student>{
        public String name;
        public int korean;
        public int english;
        public int math;

        @Override
        public int compareTo(Student o) {
            if(korean!=o.korean) return o.korean - korean;
            else{
                if(english!=o.english) return english - o.english;
                else{
                    if(math!=o.math) return o.math - math;
                    else return name.compareTo(o.name);
                }
            }
        }
    }


    static void pro(){
        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            sb.append(students[i].name+"\n");
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
