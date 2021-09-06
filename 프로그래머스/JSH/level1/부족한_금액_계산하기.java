package study_of_hell.프로그래머스.JSH.level1;

public class 부족한_금액_계산하기 {
    public static void main(String[] args) {
        int price = 3, money = 100, count = 4;
        System.err.println(solution(price, money, count));
    }

    public static long solution(int price, int money, int count) {
        long finalPrice = getPrice(price, count, 1);
        return money >= finalPrice ? 0 : finalPrice - money;
    }

    public static long getPrice(int price, int count, int index){
        if(index == count)
            return price*index;
        return price * index+getPrice(price, count, index+1);
    }
}
