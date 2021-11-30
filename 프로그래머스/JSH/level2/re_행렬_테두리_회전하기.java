package study_of_hell.프로그래머스.JSH.level2;

import java.util.Arrays;

public class re_행렬_테두리_회전하기 {
    public static void main(String[] args) {
        int[][] q1={{2,2,5,4},{3,3,6,6},{5,1,6,3}},
                q2 = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}},
                q3 = {{1,1,100,97}};
        System.err.println(solution(6, 6, q1));
//        System.err.println(solution(3, 3, q2));
//        System.err.println(solution(100, 97, q3));

    }

    static int r;
    static int c;
    static int[][] adj;
    static int[][] q;
    static int[] answer;

    static void rotation(int[] query, int count){
        int x1 = query[0], y1 = query[1];
        int x2 = query[2], y2 = query[3];

        int start = adj[x1][y1];
        int temp;

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <=y2 ; j++) {
                if(i==x1||i==x2||j==y1||j==y2){     // 행렬 테두리일때만
                    if(i==x1&&j==y1) continue;
                    temp = start;
                    start = adj[i][j];
                    adj[i][j]=temp;
                }
            }
        }

        int curX  = x1;
        int curY = y1;

        int idx = 0;

        while(idx <4){

        }

        adj[x1][y1]=start;
        answer[count]= Integer.MAX_VALUE;

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <=c ; j++) {
                if(i==1||i==r||j==1||j==c){     // 행렬 테두리일때만
                    if(answer[count]>adj[i][j]) answer[count] = adj[i][j];
                }
            }
        }
    }

    static void pro(){
        for (int i = 0; i < q.length; i++) {
            rotation(q[i], i);
        }
    }

    static int[] solution(int rows, int columns, int[][] queries) {
        r = rows;
        c = columns;
        q = queries;
        adj = new int[r+1][c+1];
        int count = 1;
        answer = new int[queries.length];
        for (int i = 1; i <=r ; i++) {
            for (int j = 1; j <=c ; j++) {
                adj[i][j] = count++;
            }
        }

        pro();
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
