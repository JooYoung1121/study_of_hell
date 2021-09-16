package study_of_hell.프로그래머스.JSH.level1;

import java.util.stream.Stream;

public class 하샤드_수 {
    public static void main(String[] args) {
        int x1=10, x2=12, x3=11, x4=13;
        System.err.println(solution(x1));
        System.err.println(solution(x2));
        System.err.println(solution(x3));
        System.err.println(solution(x4));
    }

    public static boolean solution(int x) {
        int[] digits = Stream.of(String.valueOf(x).split("")).mapToInt(Integer::parseInt).toArray();

        int sum=0;
        for(int d: digits){
            sum+=d;
        }

        return x%sum==0?true:false;
    }
}
