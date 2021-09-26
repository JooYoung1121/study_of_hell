package study_of_hell.프로그래머스.JSH.level2;

public class _124_나라의_숫자 {
    public static void main(String[] args) {
        int n1=6, n2=7, n3=8, n4=9;
        System.err.println(solution(n1));
        System.err.println(solution(n2));
        System.err.println(solution(n3));
        System.err.println(solution(n4));
    }

    public static String solution(int n) {
        String[] numbers={"4", "1", "2"};
        String answer="";

        while(n>0){
            int remain = n%3;
            n /=3;

            if(remain ==0 ) n--;

            answer = numbers[remain] + answer;
        }


        return answer;
    }
}
