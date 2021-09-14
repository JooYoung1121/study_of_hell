package study_of_hell.프로그래머스.JSH.level1;

import java.util.ArrayList;
import java.util.List;

public class 나누어_떨어지는_숫자_배열 {
    public static int[] solution(int[] arr, int divisor){
        List<Integer> result = new ArrayList<>();
        for (int r: arr) {
            if(r%divisor==0)
                result.add(r);
        }

        return result.size()==0? new int[]{-1}: result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr1={5,9,7,10}, arr2={2, 36, 1, 3}, arr3={3,2,6};
        int div1=5, div2=1, div3=10;
        for (int r:
                solution(arr1, div1)) {
            System.err.println(r);
        }
        for (int r:
                solution(arr2, div2)) {
            System.err.println(r);
        }
        for (int r:
                solution(arr3, div3)) {
            System.err.println(r);
        }
    }
}
