package study_of_hell.프로그래머스.JSH.level1;

public class x만큼_간격이_있는_n개의_숫자 {
    public static void main(String[] args) {
        int x1=2, x2=4, x3=-4;
        int n1=5, n2=3, n3=2;
        System.err.println(solution(x1, n1));
        System.err.println(solution(x2, n2));
        System.err.println(solution(x3, n3));
    }

    public static long[] solution(int x, int n){
        long[] answer = new long[n];

        int idx=0;
        long temp =x;
        while(idx<n){
            answer[idx]=temp;
            temp+=x;
            idx++;
        }
        return answer;
    }
}
