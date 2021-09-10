package study_of_hell.프로그래머스.JSH.level1;

import java.util.ArrayList;
import java.util.List;

public class 자릿수_더하기 {
    public static void main(String[] args) {
        int n1=123, n2=987;
        System.err.println(solution(n1));
        System.err.println(solution(n2));
    }

    public static int solution(int n){
        List<Integer> arrNum = new ArrayList<>();
        while(n>0){
            arrNum.add(n%10);
            n/=10;
        }

        return arrNum.stream().mapToInt(Integer::intValue).sum();
    }
}
