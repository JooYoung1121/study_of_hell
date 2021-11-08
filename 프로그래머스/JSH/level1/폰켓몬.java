package study_of_hell.프로그래머스.JSH.level1;

import java.util.HashMap;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] n1 = {3,1,2,3}, n2={3,3,3,2,2,4}, n3 = {3,3,3,2,2,2};
        System.err.println(solution(n1));
        System.err.println(solution(n2));
        System.err.println(solution(n3));
    }

    static HashMap<Integer, Integer> map;
    static int maxPoke;
    static int count;

    public static int solution(int[] nums) {
        map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }
        maxPoke = map.size();   // 최대 종류 수
        count = nums.length/2;

        return Math.min(maxPoke, count);
    }
}
