package study_of_hell.프로그래머스.JSH.level1;

public class 최대공약수와_최소공배수 {
    public static void main(String[] args) {
        int n1=3, n2=2;
        int m1=12, m2=5;

        for (int n:
             solution(n1, m1)) {
            System.err.println(n);
        }
        for (int n:
             solution(n2,m2)) {
            System.err.println(n);
        }
    }

    public static int[] solution(int n, int m){
        int[] answer = new int[2];

        int big = Math.max(n, m);
        int small = Math.min(n,m);
        answer[0] = gcd(big, small);
        answer[1] = big*small / answer[0];

        return answer;
    }

    public static int gcd(int a, int b){
        if(a%b==0)
            return b;
        return gcd(b, a%b);
    }
}
