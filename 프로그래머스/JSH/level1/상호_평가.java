package study_of_hell.프로그래머스.JSH.level1;

import java.util.ArrayList;

public class 상호_평가 {
    public static void main(String[] args) {
        int[][] s1 = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}},
                s2 = {{50, 90}, {50, 87}},
                s3= {{70, 49, 90}, {68, 50, 38}, {73, 31, 100}};
        System.err.println(new 상호_평가().solution(s1));
        System.err.println(new 상호_평가().solution(s2));
        System.err.println(new 상호_평가().solution(s3));
    }

    public String solution(int[][] scores) {
        String answer = "";

        for (int i = 0; i < scores.length; i++) {
            ArrayList<Integer> myScore = new ArrayList<>();

            // 0번이면
            // (0,0), (1,0), (2,0)

            int max=scores[0][i], min=scores[0][i];
            int iCredit = scores[i][i]; // 내가 평가한 내 점수
            boolean isUnique=true;

            for (int j = 0; j < scores.length; j++) {
                int score = scores[j][i];
                myScore.add(score);
                if(score>max)
                    max=score;
                if(score<min)
                    min=score;

                if(i!=j && iCredit == scores[j][i])
                    isUnique=false;
            }

            if(isUnique && (iCredit==max || iCredit==min))
                myScore.remove(i);

            float avg = (float)myScore.stream().mapToInt(Integer::intValue).sum()/(float)myScore.size();

            answer+=makeCredit(avg);
        }



        return answer;
    }

    public String makeCredit(float score){
        if(score >=90)
            return "A";
        else if(80<=score&& score<90)
            return "B";
        else if(70<=score && score<80)
            return "C";
        else if(50<=score && score<70)
            return "D";
        else
            return "F";
    }
}
