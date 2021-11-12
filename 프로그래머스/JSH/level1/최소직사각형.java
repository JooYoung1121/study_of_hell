package study_of_hell.프로그래머스.JSH.level1;

import java.util.Arrays;

public class 최소직사각형 {
    public static void main(String[] args) {
        int [][] s1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}},
                s2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}},
                s3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

        System.err.println(solution(s1));
        System.err.println(solution(s2));
        System.err.println(solution(s3));
    }

    public static int solution(int[][] sizes) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
            if(sizes[i][0] >maxX) maxX=sizes[i][0];
            if(sizes[i][1] >maxY) maxY=sizes[i][1];
        }


        return maxX*maxY;
    }
}
