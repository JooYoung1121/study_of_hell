package study_of_hell.프로그래머스.JSH.level1;

import java.util.Arrays;

public class 정수_내림차순으로_배치하기 {
    public static void main(String[] args) {
        long n = 118372;
        System.err.println(solution(n));
    }

    public static long solution(long n){
        String n2String = String.valueOf(n);
        Long[] longArr = new Long[n2String.length()];
        for (int i = 0; i < n2String.length(); i++) {
            longArr[i]= Long.parseLong(String.valueOf(n2String.charAt(i)));
        }
        Arrays.sort(longArr);

        long answer = 0;
        for (int i = longArr.length-1; i >=0 ; i--) {
            answer+=Math.pow(10, i) * longArr[i];
        }
        return answer;
    }
}
