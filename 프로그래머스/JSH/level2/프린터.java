package study_of_hell.프로그래머스.JSH.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
    public static void main(String[] args) {
        int[] p1={2,1,3,2}, p2={1,1,9,1,1,1};
        int l1 = 2, l2= 0, l3 = 3;
        System.err.println(new 프린터().solution(p1, l1));
        System.err.println(new 프린터().solution(p2, l2));
    }

    class Task{
        int location;
        int priority;
        public Task(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Task> queue = new LinkedList<>();

        for(int i=0; i<priorities.length; i++){
            queue.add(new Task(i, priorities[i]));
        }

        int answer = 0;
        int now=0;
        while(!queue.isEmpty()){
            Task cur = queue.poll();

            if(queue.stream().anyMatch(s->s.priority>cur.priority)){
                queue.add(cur);
            }else{
                now++;
                if(cur.location == location) {
                    answer = now;
                    break;
                }
            }
        }
        return answer;
    }
}
