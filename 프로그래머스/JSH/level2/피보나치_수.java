package study_of_hell.프로그래머스.JSH.level2;

public class 피보나치_수 {
    public static void main(String[] args) {
        int n1=3, n2=5;
        System.err.println(solution(n1));
        System.err.println(solution(n2));
    }

    public static int solution(int n){
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            int c = (a+b)%1234567;
            a = b % 1234567;
            b = c%1234567;
        }

        return a;
    }
}
