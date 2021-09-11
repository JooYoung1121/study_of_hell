package study_of_hell.프로그래머스.JSH.level1;

public class 문자열_다루기_기본 {
    public static void main(String[] args) {
        String s1="a234", s2="1234";
        System.err.println(solution(s1));
        System.err.println(solution(s2));

    }

    public static boolean solution(String s) {
        char[] charArr= s.toCharArray();
        if(charArr.length!=4 && charArr.length!=6)
            return false;

        try{
            Integer.parseInt(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
