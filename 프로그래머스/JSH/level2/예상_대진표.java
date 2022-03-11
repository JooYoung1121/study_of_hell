package study_of_hell.프로그래머스.JSH.level2;

public class 예상_대진표 {
    public static void main(String[] args) {
        int n=8, a=4, b=7;
        System.err.println(solution(n, a, b));
    }

    public static int getOrder(int n){
        if(n%2==0) return n/2;
        else return (n+1)/2;
    }

    public static int solution(int n, int a, int b){
        int answer = 1;

        while(getOrder(a) != getOrder(b)){
            n=n/2;

            a = getOrder(a);
            b = getOrder(b);

            answer++;
        }

        return answer;
    }
}
