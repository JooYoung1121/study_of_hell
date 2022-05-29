package study_of_hell.프로그래머스.JSH.level1;

import java.util.Arrays;

public class 스킬체크2 {
    public static void main(String[] args) {
        int[] a1 = new int[]{4, 0, 3, 2, 1};
        System.err.println(Arrays.toString(solution(a1)));
    }

    public static int[] solution(int[] arr) {
        if(arr.length == 1 ) return new int[]{-1};

        int minIdx = 0;
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
                minIdx = i;
            }
        }

        int[] answer = new int[arr.length-1];

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i == minIdx) continue;
            answer[count] = arr[i];
            count++;
        }

        return answer;
    }
}
