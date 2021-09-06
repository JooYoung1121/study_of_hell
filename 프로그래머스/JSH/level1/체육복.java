package study_of_hell.프로그래머스.JSH.level1;

import java.util.Arrays;

public class 체육복 {
    public static void main(String[] args) {
        int n1 = 5, n2 = 5, n3 = 3;
        int[] lost1 = {2, 4}, lost2 = {2,4}, lost3 = {3};
        int[] reserve1 = {1, 3, 5}, reserve2 = {3}, reserve3 = {1};

        System.err.println(solution(n1, lost1, reserve1));
        System.err.println(solution(n2, lost2, reserve2));
        System.err.println(solution(n3, lost3, reserve3));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 여분 체육복이 있지만 체육복을 도난당한 학생
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if(lost[i]==reserve[j]) {
                    answer++;
                    lost[i]=reserve[j]=-1;
                    break;
                }
            }
        }
        
        // 계산
        for(int lostPerson: lost){
            for (int i = 0; i < reserve.length; i++) {
                if(reserve[i]==lostPerson+1||reserve[i]==lostPerson-1){
                    answer++;
                    reserve[i]=-1;
                    break;
                }
            }
        }

        return answer;
    }
}
