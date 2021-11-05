package study_of_hell.기타.JSH;

public class _211101_1 {
    public static void main(String[] args) {
        System.err.println(new _211101_1().solution(28));
        System.err.println(new _211101_1().solution(734));
        System.err.println(new _211101_1().solution(1990));
        System.err.println(new _211101_1().solution(1000));
    }

    public int solution(int N) {
        // write your code in Java SE 8
        int sumOfDigit = getSumOfDigit(N);

        int nextNum = N+1;
        int sum = getSumOfDigit(nextNum);

        while(sum!=sumOfDigit){
            sum = getSumOfDigit(++nextNum);
        }

        return nextNum;
    }

    public int getSumOfDigit(int N){
        int sum =0;
        while(N!=0){
            sum += N%10;
            N/=10;
        }
        return sum;
    }
}
