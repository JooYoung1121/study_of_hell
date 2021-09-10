package study_of_hell.프로그래머스.JSH.level1;

import java.util.ArrayList;
import java.util.List;

public class 약수의_합 {
    public static void main(String[] args) {
        int n1=12, n2=5;
        System.err.println(solution(n1));
        System.err.println(solution(n2));
    }

    public static int solution(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            if(n%i==0)
                list.add(i);
        }

        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
