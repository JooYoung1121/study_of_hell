package study_of_hell.프로그래머스.JSH.level1;

public class 문자열을_정수로_바꾸기 {
    public static void main(String[] args) {
        String str1="1234", str2="-1234";
        System.err.println(solution(str1));
        System.err.println(solution(str2));

    }
    public static int solution(String s){
        return Integer.parseInt(s);
    }
}
