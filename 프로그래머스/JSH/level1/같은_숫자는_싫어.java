package study_of_hell.프로그래머스.JSH.level1;

import java.util.ArrayList;
import java.util.List;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        int[] arr1={1,1,3,3,0,1,1}, arr2={4,4,4,3,3};
        for (int a: solution(arr1)) {
            System.err.println(a);
        }
        for (int a: solution(arr2)) {
            System.err.println(a);
        }
    }

    public static int[] solution(int []arr) {
        List<Integer> arrList = new ArrayList<>();

        arrList.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]!=arr[i-1]) {
                arrList.add(arr[i]);
            }
        }

        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }
}
