package study_of_hell.프로그래머스.JSH.level2;

import java.util.Arrays;

public class 스킬체크1 {
    public static void main(String[] args) {
        long[] n1 = new long[]{2, 7};
        System.err.println(Arrays.toString(solution(n1)));
    }


    public static boolean check(String binary, long num){
        String check = Long.toBinaryString(num);

        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) != check.charAt(i)) count++;

            if(count > 2) return false;
        }

        return true;
    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i]+1;
            String binary = Long.toBinaryString(numbers[i]);
            while(true){
                if(check(binary, num)) break;
                num++;
            }
            answer[i] = num;
        }

        return answer;
    }
}
