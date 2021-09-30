package study_of_hell.프로그래머스.JSH.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 기능개발 {
    public static void main(String[] args) {
        int[] p1 = {93, 30, 55}, p2 = {95, 90, 99, 99, 80, 99};
        int[] s1 = {1,30,5}, s2={1, 1, 1, 1, 1, 1};

        for (int s:solution(p1, s1)) {
            System.out.print(s+" ");
        }
        System.out.println();
        for (int s:solution(p2, s2)) {
            System.out.print(s+" ");
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();

        for (int i = progresses.length-1; i >=0; i--) {
            stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));
        }

        List<Integer> s = new ArrayList<>();

        while(!stack.isEmpty()){
            int cnt = 1;

            int top = stack.pop();

            while(!stack.isEmpty() && stack.peek() <=top){
                cnt++;
                stack.pop();
            }

            s.add(cnt);
        }

        return s.stream().mapToInt(Integer::intValue).toArray();
    }
}
