package study_of_hell.프로그래머스.JSH.level2;

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {
    public static void main(String[] args) {
        String n1 = "17", n2 = "011", n3="2", n4="7843", n5="9999999", n6="1276543";
        System.err.println(solution(n1));
        System.err.println(solution(n2));
        System.err.println(solution(n3));
        System.err.println(solution(n4));
        System.err.println(solution(n5));
        System.err.println(solution(n6));
    }

    public static int solution(String numbers){
        // numbers를 char[] 배열로 쪼개기
        answer="";
        answerSet= new HashSet<>();
        chars = numbers.split("");
        visit = new Boolean[chars.length];

        for (int i = 0; i < chars.length ; i++) {
            visit[i]=false;
        }

        for (int i = 1; i <= chars.length ; i++) {
            recFunc(i);
        }
        System.err.println(answerSet);

        return answerSet.size();
    }

    static String[] chars;
    static String answer;
    static Boolean[] visit;
    static Set<Integer> answerSet;

    public static void recFunc(int count){
        if(answer.length()==count){
            Integer answerInt = Integer.parseInt(answer);
            System.out.println(answerInt);
            if(isPrimeNumber(answerInt)) answerSet.add(answerInt);
        }else{
            for (int i = 0; i <chars.length; i++) {
                if(!visit[i]){
                    answer +=chars[i];
                    visit[i] = true;
                    recFunc(count);
                    answer=answer.substring(0, answer.length()-1);
                    visit[i] = false;
                }
            }
        }
    }

    // num이 소수이면 true, 아니면 false
    public static boolean isPrimeNumber(Integer num){
        if(num==2)  // 2이면 소수
            return true;

        if(num==1|| num==0 || num%2==0)    // 2의 배수면 소수가 아님
            return false;

        for (int i = 3; i <num/2 ; i+=2) {
            if(num%i==0)
                return false;
        }

        return true;
    }
}
