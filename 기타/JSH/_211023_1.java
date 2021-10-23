package study_of_hell.기타.JSH;

public class _211023_1 {
    public static void main(String[] args) {
        System.err.println(new _211023_1().solution(4));
    }

    public int solution(int n) {
        // 2n + 1
        // 1 => 0
        // 2 => 1, 2,  3
        // 3 => 4, 5,  6,  7,  8
        // 4 => 9, 10, 11, 12, 13, 14, 15
        // 5 => 16,17, 18, 19, 20, 21, 22, 23, 24
        // pow(n,2) -1 까지
        int count = (int)Math.pow(n, 2)-1;

        return calculate(count) + calculate(count-1) + calculate(count-2);
    }

    public int calculate(int count){
        return (2*count) +1;
    }
}
