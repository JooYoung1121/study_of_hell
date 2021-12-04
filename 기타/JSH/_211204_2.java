package study_of_hell.기타.JSH;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _211204_2 {
    public static void main(String[] args) {
        String[] r1 = {"A 3","B 2"},
                r2= {"SPAGHETTI 3", "FRIEDRICE 2", "PIZZA 8"},
                r3= {"COOKIE 10000"};
        String [] o1= {"A 1","A 2","B 3","B 4"},
                o2 = {"PIZZA 1", "FRIEDRICE 2", "SPAGHETTI 4", "SPAGHETTI 6", "PIZZA 7", "SPAGHETTI 8"},
                o3={"COOKIE 300000"};
        int n1 = 2, n2=3, n3=1;
        System.err.println(solution(n1, r1, o1));
        System.err.println(solution(n2, r2, o2));
        System.err.println(solution(n3, r3, o3));
    }

    static int[] fire;
    static HashMap<String, Integer> recipeMap;  // {음식이름: 조리시간}
    static int allTime;
    static Queue<Order> orderQueue;
    static Queue<Order> waitQueue;
    static int answer;

    public static class Order{
        String name;
        int time;
        boolean isLast;

        public Order(String n, int t, boolean l){
            name = n;
            time = t;
            isLast = l;
        }
    }

    static void cook(){
        for (int i = 0; i < fire.length ; i++) {
            if(fire[i]!=0) fire[i]-=1;
        }

        if(!waitQueue.isEmpty()){
            for (int i = 0; i < fire.length ; i++) {
                if(fire[i]==0){ //비어있는 화로가 있다면
                    Order order = waitQueue.poll();
                    int cookTime = recipeMap.get(order.name);
                    if(order.isLast) answer=allTime+cookTime;
                    fire[i]=cookTime;   // 조리 시작
                }

                if(waitQueue.isEmpty()) break;
            }
        }
    }

    public static int solution(int n, String[] recipes, String[] orders) {
        fire = new int[n];
        for (int i = 0; i < n; i++) {
            fire[i]=0;
        }
        recipeMap = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String[] temp= recipes[i].split(" ");
            String name = temp[0];
            int time = Integer.parseInt(temp[1]);
            recipeMap.put(name,time);
        }
        allTime =1;

        orderQueue = new LinkedList<>();
        waitQueue = new LinkedList<>();
        for (int i = 0; i < orders.length; i++) {
            String[] temp= orders[i].split(" ");
            String name = temp[0];
            int time = Integer.parseInt(temp[1]);

            // 마지막 주문이라면 isLast 를 true로
            if(i==orders.length-1) orderQueue.add(new Order(name, time, true));
            else orderQueue.add(new Order(name, time, false));
        }

        answer=0;
        while(!orderQueue.isEmpty()||!waitQueue.isEmpty()){
            if(!orderQueue.isEmpty()){
                Order order = orderQueue.peek();

                if(order.time==allTime){    // 만약 주문 시간이 지금 시간과 같다면
                    order = orderQueue.poll();

                    waitQueue.add(order);   // 대기 큐에 order을 넣기
                }
            }
            cook();
            if(answer!=0) break;
            allTime++;
        }

        return answer;
    }
}
