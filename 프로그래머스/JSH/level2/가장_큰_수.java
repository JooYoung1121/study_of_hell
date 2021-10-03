package study_of_hell.프로그래머스.JSH.level2;

import java.util.Arrays;
import java.util.Comparator;

public class 가장_큰_수 {
    public static void main(String[] args) {
        int[] n1 = {6, 10, 2}, n2 = {3, 30, 34, 5, 9};
        System.err.println(new 가장_큰_수().solution(n1));
        System.err.println(new 가장_큰_수().solution(n2));
    }

    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strings[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(strings[0].equals("0"))  return "0";

        String answer = "";
        for (String s:strings) {
            answer+=s;
        }
        return answer;
    }
}
