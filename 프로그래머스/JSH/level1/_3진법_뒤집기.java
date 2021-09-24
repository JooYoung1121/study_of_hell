package study_of_hell.프로그래머스.JSH.level1;

public class _3진법_뒤집기 {
    public static void main(String[] args) {
        int n1=45, n2=125;
        System.err.println(solution(n1));
        System.err.println(solution(n2));
    }

    public static int solution(int n) {
        String s3="";
        while(n>0){
            s3=(n%3)+s3;
            n/=3;
        }

        int answer = 0;
        for (int i = 0; i < s3.length(); i++) {
            answer+= Character.getNumericValue(s3.charAt(i)) * Math.pow(3, i);
        }

        return answer;
    }
}
