package study_of_hell.프로그래머스.JSH.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};

        System.out.println(Arrays.toString(solution(answers1)));
        System.out.println(Arrays.toString(solution(answers2)));
    }

    public static int[] solution(int[] answers) {
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};      // 수학 문제를 찍는 패턴

        int s1=0, s2=0, s3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if(person1[i%person1.length]==answers[i]) s1++;
            if(person2[i%person2.length]==answers[i]) s2++;
            if(person3[i%person3.length]==answers[i]) s3++;
        }

        int max = Math.max(Math.max(s1, s1), s3);

        List<Integer> list = new ArrayList<>();
        if(max==s1) list.add(1);
        if(max==s2) list.add(2);
        if(max==s3) list.add(3);

        int[] answer = new int[ list.size()];
        for( int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
