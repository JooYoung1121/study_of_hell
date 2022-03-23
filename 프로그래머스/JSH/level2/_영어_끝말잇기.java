package study_of_hell.프로그래머스.JSH.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _영어_끝말잇기 {
    public static void main(String[] args) {
        int n1 = 3, n2 = 5, n3 = 2;
        String[] w1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"},
                w2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish",
                        "hang", "gather", "refer", "reference", "estimate", "executive"},
                w3 = {"hello", "one", "even", "never", "now", "world", "draw"};

        System.err.println(Arrays.toString(solution(n1, w1)));
        System.err.println(Arrays.toString(solution(n2, w2)));
        System.err.println(Arrays.toString(solution(n3, w3)));
    }

    static Map<String, Integer> map;

    public static boolean canPass(String word, String before){
        if(word.length() == 1) return false;    // 한글자의 경우 탈락
        if(!word.startsWith(String.valueOf(before.charAt(before.length()-1)))) return false;    // 끝말잇기 x
        if(map.containsKey(word)) return false; // 전에 나온적이 있다면

        return true;
    }

    public static int[] solution(int n, String[] words) {
        map = new HashMap<>();

        int[] answer = new int[2];
        String before = words[0];
        map.put(before, 1);
        for (int i = 1; i < words.length; i++) {
            if(canPass(words[i], before)){
                map.put(words[i], 1);
                before = words[i];
            }else{
                answer[0] = (i % n)+1;
                answer[1] = (i / n)+1;
                break;
            }
        }

        return answer;
    }
}
