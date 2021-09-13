package study_of_hell.프로그래머스.JSH.level1;

import java.util.ArrayList;
import java.util.List;

public class 소수_찾기 {
    public static void main(String[] args) {
        int n1=10, n2=5;

        System.err.println(solution(n1));
        System.err.println(solution(n2));
    }

    public static int solution(int n){
        int answer = 0;

        for (int i = 2; i <=n; i++) {
            if(i==2){
                answer++;
                continue;
            }

            if(i%2==0)
                continue;

            boolean flag = true;
            for (int j = 3; j <=(int)Math.sqrt(i); j+=2) {
                if(i%j==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
        }

        return answer;
    }
}
