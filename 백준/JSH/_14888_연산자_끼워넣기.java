package study_of_hell.백준.JSH;

import java.io.*;
import java.util.StringTokenizer;

public class _14888_연산자_끼워넣기 {
    static StringBuilder sb = new StringBuilder();

    static void input(){
        FastReader scan = new FastReader();
        N= scan.nextInt();
        nums = new int[N+1];
        operators = new int[5];
        order = new int[N+1];
        for(int i=1; i<=N;i++)  nums[i] = scan.nextInt();
        for(int i=1;i<=4;i++)   operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min;
    static int[] nums, operators, order;

    // 피연산자 2개와 연산자가 주어졌을 때 계산하는 함수
    static int calculator(int operand1, int operator, int operand2){
        // nums, order
        switch(operator){
            case 1: // +
                return operand1 + operand2;
            case 2: // -
                return operand1 - operand2;
            case 3: // *
                return operand1 * operand2;
            case 4: // /
                return operand1 / operand2;
            default:
                return 0;
        }
    }


    // order[1..N-1] 에 연산자들이 순서대로 저장된다
    // k-1 번째 연산자까지 계산한 결과가 value
    static void rec_func(int k, int value){
        if(k==N){   // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
            // 정한 연산자 순서대로 계산해서 정답을 갱신하기
//            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        }else{  // k 번째 연산자는 무엇을 선택할 것인가?
            for(int cand = 1; cand<=4;cand++){
                if(operators[cand]>=1){
                    operators[cand]--;
                    order[k]=cand;
                    int new_value = calculator(value, cand, nums[k+1]);
                    rec_func(k+1, new_value);
                    operators[cand]++;
                    order[k]=0;
                }
            }
            // 4가지의 연산자들 중에 뭘 쓸 것인지 선택하고 재귀호출하기
        }

    }

    public static void main(String[] args) {
        input();

        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
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
