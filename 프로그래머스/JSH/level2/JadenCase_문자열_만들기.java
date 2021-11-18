package study_of_hell.프로그래머스.JSH.level2;

public class JadenCase_문자열_만들기 {
    public static void main(String[] args) {
        System.err.println(solution("3people unFollowed me"));
        System.err.println(solution("for the last week"));
        System.err.println(solution(" adgagd 3eagdag "));

    }

    public static String solution(String s){
        s = s.toLowerCase();

        StringBuffer sb = new StringBuffer(s);
        String sbString = sb.toString();

        sb.setCharAt(0, String.valueOf(sbString.charAt(0)).toUpperCase().charAt(0));

        for (int i = 1; i < sbString.length(); i++) {
            if(String.valueOf(sbString.charAt(i-1)).equals(" ")) {
                sb.setCharAt(i, String.valueOf(sbString.charAt(i)).toUpperCase().charAt(0));
            }
        }

        return sb.toString();
    }
}
