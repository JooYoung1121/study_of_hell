package study_of_hell.프로그래머스.JSH.level2;

import java.util.Arrays;

public class 구명보트 {

    public static void main(String[] args) {
        int[] p1 = {70,50,80,50}, p2={70,80,50};
        int limit =100;
        System.err.println(solution(p1, limit));
        System.err.println(solution(p2, limit));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int back = people.length-1, count = people.length;
        int front = 0;

        int answer = 0;

        while(count>0){
            if(people[front]+people[back]<=limit){
                front++;
                back--;
                count-=2;
            }else{
                back--;
                count-=1;
            }
            answer++;
        }

        return answer;
    }
}
