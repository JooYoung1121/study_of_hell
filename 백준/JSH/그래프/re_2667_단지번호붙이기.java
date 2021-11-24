package study_of_hell.백준.JSH.그래프;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class re_2667_단지번호붙이기 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, group_cnt;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;

    static void input() {
        N = sc.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextLine();
        }
        visit = new boolean[N][N];
    }

    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x, int y) {
        group_cnt++;
        visit[x][y]=true;
        for (int k = 0; k < 4; k++) {
            int nx = x+dir[k][0];
            int ny = y+dir[k][1];
            if(nx<0 || ny<0 ||nx>=N || ny>=N) continue;
            if(a[nx].charAt(ny)=='0') continue;
            if(visit[nx][ny])continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
        group= new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j]&&a[i].charAt(j)=='1'){
                    //갈 수 있는 칸이면서 새롭게 만난 단지인 경우
                    group_cnt =0;
                    dfs(i, j);
                    group.add(group_cnt);
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
