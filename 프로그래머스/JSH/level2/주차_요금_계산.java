package study_of_hell.프로그래머스.JSH.level2;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class 주차_요금_계산 {
    public static void main(String[] args) {
        int[] f1 = {180, 5000, 10, 600}, f2 = {120, 0, 60, 591}, f3 = {1, 461, 1, 10};
        String[] r1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"},
                r2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"},
                r3 = {"00:00 1234 IN"};

        System.err.println(Arrays.toString(solution(f1, r1)));
        System.err.println(Arrays.toString(solution(f2, r2)));
        System.err.println(Arrays.toString(solution(f3, r3)));
    }

    static class Car{
        String num;
        LocalTime in;
        int minute;

        Car(String num){
            this.num = num;
            this.minute = 0;
        }
    }

    static Map<String, Car> map;

    private static int getMinutes(LocalTime time){
        return time.getHour() * 60 + time.getMinute();
    }

    public static int[] solution(int[] fees, String[] records) {
        map = new HashMap<>();

        for(String record : records){
            String[] arr = record.split(" ");
            String num = arr[1];

            Car car = new Car(num);
            if(map.containsKey(num)){
                car = map.get(num);
            }

            String type = arr[2];
            if(type.equals("IN")){
                car.in = (LocalTime.parse(arr[0]));
            }else{
                car.minute += getMinutes(LocalTime.parse(arr[0])) - getMinutes(car.in);
                car.in = null;
            }

            map.put(num, car);
        }

        List<String> keySet = map.keySet().stream().sorted().collect(Collectors.toList());

        int[] answer = new int[keySet.size()];
        int idx = 0;

        int baseMinute = fees[0];
        int baseFee = fees[1];
        int unitMinute = fees[2];
        int unitFee = fees[3];

        for(String key : keySet){
            Car car = map.get(key);
            if(car.in != null){
                car.minute += getMinutes(LocalTime.parse("23:59")) - getMinutes(car.in);
            }

            int minute = map.get(key).minute;
            answer[idx++] = minute >= baseMinute ?
                    baseFee + (int)Math.ceil((double)(minute - baseMinute) / unitMinute )*unitFee : baseFee;
        }

        return answer;
    }
}
