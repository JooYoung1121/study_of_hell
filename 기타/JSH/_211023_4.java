package study_of_hell.기타.JSH;

public class _211023_4 {
    public static void main(String[] args) {
        System.err.println(new _211023_4().solution(3));
        System.err.println(new _211023_4().solution(8));
    }

    public String solution(int size) {
        return size%2==0? "짝" : "홀";
    }
}
