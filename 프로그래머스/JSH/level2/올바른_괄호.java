package study_of_hell.프로그래머스.JSH.level2;

public class 올바른_괄호 {
    public static void main(String[] args) {
        System.err.println(solution("()()"));
        System.err.println(solution("(())()"));
        System.err.println(solution(")()("));
        System.err.println(solution("(()("));
        System.err.println(solution("())("));
    }

    static int count;

    public static boolean solution(String s){
        if(s.charAt(0)!='(')
            return false;

        count=1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)=='(') count++;
            else count--;

            if(count<0) return false;
        }

        return count==0 ? true: false;
    }
}
