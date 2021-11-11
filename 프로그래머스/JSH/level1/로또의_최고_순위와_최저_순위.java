package study_of_hell.프로그래머스.JSH.level1;

import java.util.Arrays;

public class 로또의_최고_순위와_최저_순위 {
    public static void main(String[] args) {
        int[] l1 = {44, 1, 0, 0, 31, 25}, l2={0, 0, 0, 0, 0, 0}, l3={45, 4, 35, 20, 3, 9};
        int[] w1 = {31, 10, 45, 1, 6, 19}, w2={38, 19, 20, 40, 15, 25}, w3={20, 9, 3, 45, 4, 35};

        System.err.println(Arrays.toString(solution(l1, w1)));
        System.err.println(Arrays.toString(solution(l2, w2)));
        System.err.println(Arrays.toString(solution(l3, w3)));
    }

    static int minRate;
    static int maxRate;

    public static int[] solution(int[] lottos, int[] win_nums) {

        // lottos와 win_nums 배열에서 같은 숫자 갯수
        int sameNum = (int) Arrays.stream(win_nums).filter(n->
            Arrays.stream(lottos).anyMatch(s->s==n)
        ).count();

        minRate = sameNum >=2 ? 7-sameNum : 6;

        int countZero = (int) Arrays.stream(lottos).filter(l->l==0).count();
        maxRate = sameNum+countZero >=2 ? 7-(sameNum+countZero) : 6;


        return new int[]{maxRate, minRate};
    }
}
