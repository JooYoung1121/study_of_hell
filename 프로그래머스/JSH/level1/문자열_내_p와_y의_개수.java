package study_of_hell.프로그래머스.JSH.level1;

public class 문자열_내_p와_y의_개수 {
    public static void main(String[] args) {
        String s1="pPoooyY", s2="Pyy";

        System.err.println(solution(s1));
        System.err.println(solution(s2));
    }

    public static boolean solution(String s) {
        char[] charArray= s.toCharArray();
        int pCount=0, yCount=0;

        for(char c: charArray){
            if(Character.toLowerCase(c)=='p')
                pCount++;
            else if(Character.toLowerCase(c)=='y')
                yCount++;
        }

        return pCount==yCount?true:false;
    }
}
