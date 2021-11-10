package study_of_hell.프로그래머스.JSH.level2;

public class 네트워크 {
    public static void main(String[] args) {
        int[][] c1 = {{1, 1, 0}, {1,1,0}, {0,0,1}},
                c2 = {{1,1,0},{1,1,1}, {0,1,1}};
        System.err.println(solution(3, c1));
//        System.err.println(solution(3, c2));
    }

    static boolean[] visited;
    static int[][] computers;
    static int count;

    public static int solution(int n, int[][] c) {
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        computers = c;
        count = n;

        int answer = 0;
        for (int i = 0; i <n ; i++) {
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int node){
        visited[node] = true;

        for (int i = 0; i < count; i++) {
            if(computers[node][i]== 1 && !visited[i])
                dfs(i);
        }
    }
}
