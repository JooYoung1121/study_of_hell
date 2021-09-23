package study_of_hell.프로그래머스.JSH.level1;

public class 시저_암호 {
    public static void main(String[] args) {
        String s1= "AB", s2="z", s3="a B z";
        int n1=1, n2=1, n3=4;
        System.err.println(solution(s1, n1));
        System.err.println(solution(s2, n2));
        System.err.println(solution(s3, n3));
    }

    public static String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c==' ') {    // 공백일 경우
                answer += ' ';
            }
            else if(65<=c && c<=90){    // 대문자일 경우
                answer+= c+n > 90 ? (char)(c+n-26) : (char)(c+n);
            }else{  // 소문자일 경우
                answer+= c+n > 122 ? (char)(c+n-26) : (char)(c+n);
            }
        }

        return answer;
    }
}
