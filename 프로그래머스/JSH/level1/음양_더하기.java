package study_of_hell.프로그래머스.JSH.level1;

public class 음양_더하기 {
    public static void main(String[] args) {
        int[] ab1 = {4, 7, 12}, ab2={1,2,3};
        boolean[] sign1={true, false, true}, sign2={false, false, true};
        System.err.println(solution(ab1, sign1));
        System.err.println(solution(ab2, sign2));
    }

    public static int solution(int[] absolutes, boolean[] signs){
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }
        return answer;
    }
}
