package study_of_hell.프로그래머스.JSH.level1;

import java.util.Arrays;

public class 제일_작은_수_제거하기 {
    public static int[] solution(int[] arr){
        if(arr.length==1) return new int[]{-1};

        int[] temp = arr.clone();
        Arrays.sort(arr);

        int min = arr[0];
        int[] answer = new int[temp.length-1];

        for (int i = 0, j=0; i < temp.length; i++) {
            if (temp[i] == min){
                continue;
            }
            answer[j++]=temp[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr1={4,3,2,1}, arr2={10};
        for (int r:
             solution(arr1)) {
            System.err.println(r);

        }
        for (int r:
             solution(arr2)) {
            System.err.println(r);
        }
    }
}
