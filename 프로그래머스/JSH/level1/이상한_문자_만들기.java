package study_of_hell.프로그래머스.JSH.level1;

public class 이상한_문자_만들기 {
    public static void main(String[] args) {
        String s = "ab  ab ab ab";
        System.err.println(solution(s));
    }

    public static String solution(String s){
        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
        }
        return answer;
    }
}
