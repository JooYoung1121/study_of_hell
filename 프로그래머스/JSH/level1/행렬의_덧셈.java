package study_of_hell.프로그래머스.JSH.level1;

public class 행렬의_덧셈 {
    public static void main(String[] args) {
        int[][] arr1={{1,2},{2,3}}, arr2={{3,4},{5,6}};
        int[][] ar1={{1},{2}}, ar2={{3},{4}};
        for (int[] ar: solution(arr1, arr2)) {
            for (int a: ar) {
                System.err.print(a);
            }
            System.err.println();
        }
        for (int[] ar: solution(ar1, ar2)) {
            for (int a: ar) {
                System.err.print(a);
            }
            System.err.println();
        }
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j]=arr1[i][j]+arr2[i][j];
            }
        }

        return answer;
    }
}
