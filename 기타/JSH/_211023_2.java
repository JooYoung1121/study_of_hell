package study_of_hell.기타.JSH;

import java.util.Arrays;

public class _211023_2 {
    public static void main(String[] args) {
        int[] arr1 = {100, 100, 98}, arr2={100, 100, 100};
        System.err.println(new _211023_2().solution(arr1));
        System.err.println(new _211023_2().solution(arr2));
    }

    public String[] solution(int[] numArr) {
        String[] answer = new String[2];

        double avg = Arrays.stream(numArr).average().getAsDouble();

        answer[0] = String.format("%.2f", avg);
        answer[1] = getGrade(avg);
        return answer;
    }

    public String getGrade(double score){
        if(score>=90)
            return "A";
        else if(80<=score && score<90)
            return "B";
        else if(70<=score && score<80)
            return "C";
        else if(60<=score && score<70)
            return "D";
        else
            return "F";
    }
}
