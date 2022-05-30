package study_of_hell.프로그래머스.JSH.level2;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 스킬체크2 {

    static class Car{
        String num;
        LocalTime in;
        int minute;

        Car(String num){
            this.num = num;
            this.minute = 0;
        }
    }

    static Map<String, 주차_요금_계산.Car> map;

    private static int getMinutes(LocalTime time){
        return time.getHour() * 60 + time.getMinute();
    }

    public static int[] solution(int[] fees, String[] records) {
        map = new HashMap<>();

        for(String record : records){
            String[] arr = record.split(" ");
            String num = arr[1];

            주차_요금_계산.Car car = new 주차_요금_계산.Car(num);
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
            주차_요금_계산.Car car = map.get(key);
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
