package study_of_hell.프로그래머스.JSH.level1;

public class 자연수_뒤집어_배열로_만들기 {
    public static void main(String[] args) {
        long n = 12345;
        System.err.println(solution(n));
    }

    public static int[] solution(long n){

        String s = String.valueOf(n);
        int[] answer= new int[s.length()];
        for (int i = s.length()-1, j=0; i >=0; i--, j++) {
            answer[j] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        return answer;
    }
}
