package study_of_hell.프로그래머스.JSH.level1;

public class 나머지가_1이_되는_수_찾기 {
    public static void main(String[] args) {
        System.err.println(solution(10));
        System.err.println(solution(12));
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 2; i <n ; i++) {
            if(n%i==1) return i;

        }

        return answer;
    }
}
