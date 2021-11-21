package study_of_hell.프로그래머스.JSH.level2;

import java.util.Arrays;
import java.util.Collections;

public class 최솟값_만들기 {
    public static void main(String[] args) {
        int[] a1 = {1,4,2}, a2={1,2};
        int[] b1 = {5,4,4}, b2={3,4};
        System.err.println(solution(a1, b1));
        System.err.println(solution(a2, b2));
    }

    public static int solution(int []A, int []B){
        Arrays.sort(A);
        Arrays.sort(B);

        int sum =0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i]*B[B.length-1-i];
        }

        return sum;
    }
}
