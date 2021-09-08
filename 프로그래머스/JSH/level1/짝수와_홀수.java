package study_of_hell.프로그래머스.JSH.level1;

public class 짝수와_홀수 {
    public static void main(String[] args) {
        int num1 = 3, num2= 4;
        System.err.println(solution(num1));
        System.err.println(solution(num2));
    }

    public static String solution(int num) {
        return num%2==0?"Even":"Odd";
    }
}
