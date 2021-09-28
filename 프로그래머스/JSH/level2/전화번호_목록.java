package study_of_hell.프로그래머스.JSH.level2;

import java.util.Arrays;

public class 전화번호_목록 {
    public static void main(String[] args) {
        String[] p1 = {"119", "97674223", "1195524421"}, p2={"123","456","789"}, p3={"12","123","1235","567","88"};
        System.err.println(solution(p1));
        System.err.println(solution(p2));
        System.err.println(solution(p3));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++){
            if (phone_book[i + 1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}
