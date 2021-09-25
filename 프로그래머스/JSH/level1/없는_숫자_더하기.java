package study_of_hell.프로그래머스.JSH.level1;

public class 없는_숫자_더하기{
    public static void main(String[] args) {
        int[] numbers1={1,2,3,4,6,7,8,0}, numbers2={5,8,4,0,6,7,9};
        System.err.println(solution(numbers1));
        System.err.println(solution(numbers2));
    }

    public static int solution(int[] numbers){
        int answer = 45;

        for (int n: numbers) {
            answer-=n;
        }
        return answer;
    }
}
