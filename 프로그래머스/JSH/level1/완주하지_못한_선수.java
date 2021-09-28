package study_of_hell.프로그래머스.JSH.level1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] p1 = {"leo", "kiki", "eden"}, p2={"marina", "josipa", "nikola", "vinko", "filipa"}, p3={"mislav", "stanko", "mislav", "ana"};
        String[] c1 = {"eden", "kiki"}, c2 = {"josipa", "filipa", "marina", "nikola"}, c3 = {"stanko", "ana", "mislav"};
        System.err.println(solution(p1, c1));
        System.err.println(solution(p2, c2));
        System.err.println(solution(p3, c3));
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String p: participant) {
            map.put(p, map.getOrDefault(p, 0)+1 );
        }

        for(String c: completion){
            map.put(c, map.get(c)-1);
        }

        for (String m: map.keySet()) {
            if(map.get(m)!=0)
                return m;
        }

        return null;
    }
}
