package study_of_hell.프로그래머스.JSH.level2;

public class 숫자의_표현 {
    public static void main(String[] args) {
        System.err.println(solution(15));
    }

    public static int solution(int n){
        int answer = 1;
        int sum;

        for (int i = 1; i <= n/2 +1 ; i++) {
            sum = 0;
            for (int j = i; j <=n/2 +1 ; j++) {
                sum+=j;
                if(sum>=n){
                    if(sum==n) answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
