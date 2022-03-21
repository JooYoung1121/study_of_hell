package study_of_hell.프로그래머스.JSH.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 메뉴_리뉴얼 {
    public static void main(String[] args) {
        String[] o1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                o2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                o3 = {"XYZ", "XWY", "WXA"};
        int[] c1 = {2,3,4}, c2 = {2,3,5}, c3 = {2,3,4};
        System.err.println(Arrays.toString(solution(o1, c1)));
        System.err.println(Arrays.toString(solution(o2, c2)));
        System.err.println(Arrays.toString(solution(o3, c3)));

    }

    static Map<String, Integer> map;

    public static void getWords(String word, int i, String order){
        if(i == order.length()){
            if(word.length()<=1) return;
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String result = new String(charArr);
            map.put(result, map.getOrDefault(result, 0)+1);
        }else{
            getWords(word+order.charAt(i), i+1,  order);
            getWords(word , i+1, order);
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();


        for(String order: orders){
            getWords("", 0, order);
        }

        ArrayList<String> answer = new ArrayList<>();

        ArrayList<String>[] strings = new ArrayList[course.length];
        for (int i = 0; i < course.length; i++) {
            strings[i] = new ArrayList<>();
        }

        for (String key: map.keySet()){
            if(map.get(key)>=2){
                for (int i = 0; i < strings.length ; i++) {
                    if(course[i]==key.length()){
                        if(!strings[i].isEmpty()){
                            if(map.get(strings[i].get(0)) < map.get(key)){
                                strings[i] = new ArrayList<>(){};
                                strings[i].add(key);
                            }
                            else if(map.get(strings[i].get(0))== map.get(key)){
                                strings[i].add(key);
                            }
                        }else{
                            strings[i].add(key);
                        }
                    }
                }
            }
        }

        for(ArrayList str : strings){
            answer.addAll(str);
        }

        String[] answerArr = answer.toArray(new String[0]);
        Arrays.sort(answerArr);

        return answerArr;
    }
}
