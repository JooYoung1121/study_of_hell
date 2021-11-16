package study_of_hell.프로그래머스.JSH.level2;

import java.util.Arrays;

public class N개의_최소공배수 {
    public static void main(String[] args) {
        System.err.println(solution(new int[]{2,6,8,14}));
        System.err.println(solution(new int[]{1,2,3}));
    }

    public static int solution(int[] arr){
        Arrays.sort(arr);

        int max = arr[arr.length-1];

        while(true){
            boolean check = true;
            for (int a:arr) {
                if(max%a!=0){
                    check=false;
                    break;
                }
            }
            if(check) return max;
            max++;
        }

    }

}
