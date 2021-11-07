package study_of_hell.프로그래머스.JSH.level1;

public class 키패드_누르기 {
    public static void main(String[] args) {
        int [] n1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
                n2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                n3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.err.println(solution(n1, "right"));
        System.err.println(solution(n2, "left"));
        System.err.println(solution(n3, "right"));
    }

    static Integer curLeft;
    static Integer curRight;
    static String myHand;

    public static String solution(int[] numbers, String hand) {
        curLeft = 10;   // * => 10
        curRight = 12;  // # => 12
        myHand = hand;

        StringBuilder sb = new StringBuilder();

        for (int n:numbers) {
            if(isRight(n)) {
                curRight = n;
                sb.append("R");
            }
            else {
                curLeft = n;
                sb.append("L");
            }
        }

        return sb.toString();
    }

    // 오른손으로 눌러야 하면 true, 아니면 false
    public static boolean isRight(int n){
        if(n == 1 || n == 4 || n == 7)
            return false;
        else if(n==3|| n==6 || n==9)
            return true;
        else{
            if(getLength(curLeft, n) < getLength(curRight, n))
                return false;
            else if(getLength(curLeft, n) > getLength(curRight, n))
                return true;
            else
                return myHand.equals("right");
        }
    }

    // idx : 현재 위치 , number: 앞으로 가야할 숫자
    public static int getLength(int idx, int number){
        idx = (idx == 0) ? 11: idx;
        number = (number  == 0 )? 11: number;

        int x = (idx -1)/3;
        int y = (idx -1)% 3;
        int numberX = number/3;
        int numberY = 1;

        return Math.abs(x-numberX) + Math.abs(y-numberY);
    }
}
