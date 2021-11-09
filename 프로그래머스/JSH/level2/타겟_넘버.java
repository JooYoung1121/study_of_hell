package study_of_hell.프로그래머스.JSH.level2;

public class 타겟_넘버 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,1,1,1}, 3));
    }

    static int[] numbers;
    static int target;

    public static int solution(int[] n, int t) {
        numbers = n;
        target = t;


        int answer = dfs(1, numbers[0]) + dfs(1, -numbers[0]);
        return answer;
    }

    public static int dfs(int depth, int sum){
        if(depth == numbers.length){
            if(target == sum) return 1;
            else return 0;
        }

        int result = 0;
        result += dfs(depth+1, sum+numbers[depth]);
        result += dfs(depth+1, sum-numbers[depth]);
        return result;
    }
}
