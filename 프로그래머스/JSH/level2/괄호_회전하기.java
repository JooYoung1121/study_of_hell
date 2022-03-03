package study_of_hell.프로그래머스.JSH.level2;

import java.util.Stack;

public class 괄호_회전하기 {
    public static void main(String[] args) {
        String s1="[](){}", s2="}]()[{", s3="[)(]", s4="}}}";
        System.err.println(solution(s1));
        System.err.println(solution(s2));
        System.err.println(solution(s3));
        System.err.println(solution(s4));
    }

    public static boolean isCheck(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty()){
                char a = stack.peek();
                char temp;
                if(a=='[' || a=='(' || a=='{'){
                    if(a=='[') temp=']';
                    else if(a=='(') temp=')';
                    else temp='}';
                }
                else return false;

                if(temp==s.charAt(i)){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }else{
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty() ? true : false;
    }


    public static int solution(String s) {
        int answer = 0;
        String temp;

        for (int i = 0; i < s.length(); i++) {
            temp = s.substring(i) + s.substring(0, i);
            if(isCheck(temp)) answer++;
        }

        return answer;
    }
}
