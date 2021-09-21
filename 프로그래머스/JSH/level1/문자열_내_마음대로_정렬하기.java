package study_of_hell.프로그래머스.JSH.level1;

import java.util.*;

public class 문자열_내_마음대로_정렬하기 {
    public static void main(String[] args) {
        String[] str1= {"sun", "bed", "car"}, str2={"abce", "abcd", "cdx"};
        int n1= 1, n2 = 2;
        System.err.println(solution(str1, n1));
        for (String s: solution(str1, n1)) {
            System.err.println(s);
        }
        for (String s: solution(str2, n2)) {
            System.err.println(s);
        }
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n)==o2.charAt(n)){
                    return o1.compareTo(o2);
                }
                return o1.charAt(n) < o2.charAt(n) ? -1: 1;
            }
        });

        return strings;
    }

}
