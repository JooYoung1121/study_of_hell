package study_of_hell.프로그래머스.JSH.level1;

import java.util.Map;

public class 숫자_문자열과_영단어 {
    public static void main(String[] args) {
        String s1="one4seveneight", s2="23four5six7", s3="2three45sixseven", s4="123";
        System.err.println(solution(s1));
        System.err.println(solution(s2));
        System.err.println(solution(s3));
        System.err.println(solution(s4));
    }

    public static int solution(String s) {
        Map<String, Integer> map = Map.of(
                "zero",0,
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9
        );

        for (String key: map.keySet()) {
            if(s.contains(key))
                s = s.replaceAll(key, String.valueOf(map.get(key)));
        }

        return Integer.parseInt(s);
    }
}
