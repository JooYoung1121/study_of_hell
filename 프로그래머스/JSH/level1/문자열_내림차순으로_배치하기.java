package study_of_hell.프로그래머스.JSH.level1;

import java.util.Arrays;
import java.util.Collections;

public class 문자열_내림차순으로_배치하기 {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.err.println(solution(s));
    }

    public static String solution(String s){
        Character[] charArr = new Character[s.length()];

        for (int i = 0; i < charArr.length; i++) {
            charArr[i]=s.charAt(i);
        }

        Arrays.sort(charArr, Collections.reverseOrder());

        String answer="";
        for (int i = 0; i < charArr.length; i++) {
            answer+=charArr[i];
        }
        return answer;
    }
}
