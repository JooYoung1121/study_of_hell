package study_of_hell.프로그래머스.JSH.level1;

public class 정수_제곱근_판별 {
    public static void main(String[] args) {
        long n1 = 121, n2=3;
        System.err.println(solution(n1));
        System.err.println(solution(n2));
    }

    public static long solution(long n){
        float d = (float) Math.sqrt(n);

        return d==(int)d ? (long) Math.pow(d + 1, 2) : -1;
    }
}
