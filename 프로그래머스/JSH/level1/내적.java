package study_of_hell.프로그래머스.JSH.level1;

public class 내적 {
    public static void main(String[] args) {
        int[] a1 = {1,2,3,4}, a2={-1,0,1};
        int[] b1= {-3,-1,0,2}, b2={1,0,-1};
        System.err.println(solution(a1,b1));
        System.err.println(solution(a2,b2));
    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer+=a[i]*b[i];
        }
        return answer;
    }
}
