package study_of_hell.프로그래머스.JSH.level2;

import java.util.Arrays;

public class 카펫 {
    public static void main(String[] args) {
        System.err.println(Arrays.toString(solution(10, 2)));
        System.err.println(Arrays.toString(solution(8, 1)));
        System.err.println(Arrays.toString(solution(24, 24)));
    }

    static int sum;
    static int row;
    static int col;


    public static int[] solution(int brown, int yellow) {
        sum = brown+yellow;
        row = Integer.MAX_VALUE;
        col = 0;

        for (int i = 2; i <= (sum/2) ; i++) {
            if(sum%i==0){
                int a = i, b=sum/i;
                if(a>=b && row-col > a-b && (a-2) * (b-2)==yellow) {
                    row = a;
                    col = b;
                }
            }
        }

        return new int[]{row, col};
    }
}
