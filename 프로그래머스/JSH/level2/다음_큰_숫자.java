package study_of_hell.프로그래머스.JSH.level2;

public class 다음_큰_숫자 {
    public static void main(String[] args) {
        System.err.println(solution(78));
        System.err.println(solution(15));
    }

    public static int solution(int n){
        int nextInt = n+1;

        int myOneCount = Integer.bitCount(n);
        while(true){
            if(myOneCount==Integer.bitCount(nextInt)) break;
            nextInt++;
        }

        return nextInt;
    }
}
