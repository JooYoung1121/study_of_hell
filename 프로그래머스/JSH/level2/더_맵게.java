package study_of_hell.프로그래머스.JSH.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class 더_맵게 {
    public static void main(String[] args) {
        int[] s = {1,2,3,9,10,12};
        int k = 7;
        System.err.println(new 더_맵게().solution(s, k));
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int s: scoville) {
            heap.offer(s);
        }


        while(heap.peek()< K){
            if(heap.size()<2) return -1;

            int f1 = heap.poll();
            int f2 = heap.poll();

            int newFood = f1 + f2*2;

            heap.offer(newFood);
            answer++;
        }

        return answer;

    }
}
