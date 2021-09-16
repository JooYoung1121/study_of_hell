package study_of_hell.프로그래머스.JSH.level1;

public class 콜라츠_추측 {
    public static void main(String[] args) {
        int n1=6, n2=16, n3=626331;
//        System.err.println(solution(n1));
//        System.err.println(solution(n2));
        System.err.println(solution(n3));
    }

    public static int solution(int num){

        int result=0;
        while(num!=1){
            if(num%2==0)
                num/=2;
            else
                num=num*3+1;
            result++;
            if(result>=500){
                result=-1;
                break;
            }
        }

        return result;
    }
}
