package study_of_hell.프로그래머스.JSH.level1;

public class 약수의_개수와_덧셈 {
    public static void main(String[] args) {
        int left1 = 13, left2 = 24;
        int right1 = 17, right2 = 27;
        System.err.println(solution(left1, right1));
        System.err.println(solution(left2, right2));
    }

    public static int solution(int left, int right){
        int answer = 0;

        for (int i = left; i <=right ; i++) {
            answer += isDivEven(i) ? i : -i;
        }

        return answer;
    }

    public static boolean isDivEven(int num){   // 약수의 갯수가 짝수면 true
        return Math.sqrt(num) == (int)Math.sqrt(num) ? false: true;
    }
}
