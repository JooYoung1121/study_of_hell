package study_of_hell.프로그래머스.JSH.level2;

import java.util.Arrays;

public class 최댓값과_최솟값 {
    public static void main(String[] args) {
        System.err.println(solution("4 2 3 1"));
        System.err.println(solution("-4 -2 -1 -3"));
        System.err.println(solution("-1 -1"));
    }

    public static String solution(String s){
        int[] numArr = Arrays.stream(s.split(" ")).mapToInt(n->Integer.parseInt(n)).toArray();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < numArr.length ; i++) {
            if(max<numArr[i]) max=numArr[i];
            if(min>numArr[i]) min=numArr[i];
        }

        return min+" "+max;
    }
}
