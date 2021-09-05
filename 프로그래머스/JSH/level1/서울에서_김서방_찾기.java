package study_of_hell.프로그래머스.JSH.level1;

import java.util.Arrays;

public class 서울에서_김서방_찾기 {
    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};

        System.err.println(solution(seoul));
    }

    public static String solution(String[] seoul) {
        int index = Arrays.asList(seoul).indexOf("Kim");
        return String.format("김서방은 %d에 있다" , index);
    }
}
