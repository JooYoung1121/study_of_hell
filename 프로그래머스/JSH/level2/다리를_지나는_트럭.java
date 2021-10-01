package study_of_hell.프로그래머스.JSH.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public static void main(String[] args) {
        int b1 = 2, b2 = 100, b3 = 100;
        int w1 = 10, w2 = 100, w3= 100;
        int[] t1 = {7,4,5,6}, t2={10}, t3={10,10,10,10,10,10,10,10,10,10};
        System.err.println(new 다리를_지나는_트럭().solution(b1, w1, t1));
        System.err.println(new 다리를_지나는_트럭().solution(b2, w2, t2));
        System.err.println(new 다리를_지나는_트럭().solution(b3, w3, t3));
    }

    class Truck{
        int weight;
        int curTime;

        public Truck(int weight, int curTime){
            this.weight= weight;
            this.curTime = curTime;
        }

        @Override
        public String toString() {
            return "Truck{" +
                    "weight=" + weight +
                    ", curTime=" + curTime +
                    '}';
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> q = new LinkedList<>();
        Queue<Truck> walking = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            q.add(new Truck(truck_weights[i], 0));
        }

        int answer = 0;
        while(!q.isEmpty()||!walking.isEmpty()){
            // 종료조건: q가 비어있고, walking이 비어있을 때
            Truck cur = q.peek();

            Truck walk = walking.peek();
            if(walk!=null && walk.curTime==bridge_length){
                walking.remove();
            }

            if(cur!=null && walking.stream().mapToInt(s->s.weight).sum() + cur.weight <= weight){
                q.remove();
                walking.add(cur);
            }

            for (Truck truck : walking) {
                truck.curTime++;
            }
            answer++;
        }

        return answer;
    }
}
