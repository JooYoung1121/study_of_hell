package study_of_hell.기타.JSH;

import java.util.Arrays;
import java.util.HashMap;

public class _211204_3 {
    public static void main(String[] args) {
        System.err.println(solution("abcc"));
        System.err.println(solution("tooth"));
        System.err.println(solution("zzz"));
    }

    static HashMap<String, Integer> map;
    static HashMap<String, int[]> keyboard;
    static int answer;
    static int[] temp;

    static int getComplex(String s){
        int complex = 0;
        if(s.length()==2){
            String a = String.valueOf(s.charAt(0));
            String b = String.valueOf(s.charAt(1));

            int ax = keyboard.get(a)[0];
            int ay = keyboard.get(a)[1];
            int bx = keyboard.get(b)[0];
            int by = keyboard.get(b)[1];

            complex = Math.abs(ax-bx) + Math.abs(ay-by);
        }
        return complex;
    }

    static void sliceStr(String s){
        for (int j = 0; j <= s.length()-2; j++) {
            String str = s.substring(j, j+2);
            int complexity = getComplex(str);
            temp[j] = complexity;
        }

        System.err.println(Arrays.toString(temp));
        for (int i = 0; i < temp.length; i++) {
            int sum =0;
            for (int j = 1; j <= temp.length-i; j++) {
                sum+=temp[i];
            }
            System.err.println(sum);
            answer+=sum;
        }

    }

    public static int solution(String s) {
        initialize();   // 키보드 초기화
        map=new HashMap<>();
        answer=0;
        temp= new int[s.length()-1];
        sliceStr(s);
        return answer;
    }

    public static void initialize(){
        keyboard = new HashMap<String, int[]>();
        keyboard.put("q", new int[]{0, 0});
        keyboard.put("w", new int[]{0, 1});
        keyboard.put("e", new int[]{0, 2});
        keyboard.put("r", new int[]{0, 3});
        keyboard.put("t", new int[]{0, 4});
        keyboard.put("y", new int[]{0, 5});
        keyboard.put("u", new int[]{0, 6});
        keyboard.put("i", new int[]{0, 7});
        keyboard.put("o", new int[]{0, 8});

        keyboard.put("p", new int[]{1, 0});
        keyboard.put("a", new int[]{1, 1});
        keyboard.put("s", new int[]{1, 2});
        keyboard.put("d", new int[]{1, 3});
        keyboard.put("f", new int[]{1, 4});
        keyboard.put("g", new int[]{1, 5});
        keyboard.put("h", new int[]{1, 6});
        keyboard.put("j", new int[]{1, 7});
        keyboard.put("k", new int[]{1, 8});

        keyboard.put("l", new int[]{2, 0});
        keyboard.put("z", new int[]{2, 1});
        keyboard.put("x", new int[]{2, 2});
        keyboard.put("c", new int[]{2, 3});
        keyboard.put("v", new int[]{2, 4});
        keyboard.put("b", new int[]{2, 5});
        keyboard.put("n", new int[]{2, 6});
        keyboard.put("m", new int[]{2, 7});
    }

}
