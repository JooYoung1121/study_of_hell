package study_of_hell.프로그래머스.JSH.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 두_개_뽑아서_더하기 {
    public static void main(String[] args) {
        int[] numbers1={2,1,3,4,1}, numbers2={5,0,2,7};
        for (int a: solution(numbers1)){
            System.err.println(a);
        }
        for(int a : solution(numbers2)){
            System.err.println(a);
        }
    }

    public static int[] solution(int[] numbers){
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }

        return  set.stream().sorted().mapToInt(n->n.intValue()).toArray();
    }
}
