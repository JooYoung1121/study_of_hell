package study_of_hell.프로그래머스.JSH.level2;

import java.util.HashMap;
import java.util.Set;

public class 위장 {
    public static void main(String[] args) {
        String[][] c1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] c2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.err.println(solution(c1));
        System.err.println(solution(c2));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> clothesMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0)+1);
        }

        Set<String> keySet = clothesMap.keySet();
        for (String key:keySet) {
            answer *= clothesMap.get(key)+1;
        }

        return answer-1;
    }
}
