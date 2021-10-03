package study_of_hell.프로그래머스.JSH.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class H_Index {
    public static void main(String[] args) {
        int[] c = {3, 0, 6, 1, 5}, c1 = {3, 1, 1, 1, 4}, c2= {0, 0, 0, 0, 0, 0, 0};
        int[] c3 = {0,0,0,1}, c4={9,9,9,12}, c5 = {1,1,5,7,6};
////        System.err.println(new H_Index().solution(c));
//        System.err.println(new H_Index().solution(c1));
//        System.err.println(new H_Index().solution(c2));
//        System.err.println(new H_Index().solution(c3));
        System.err.println(new H_Index().solution(c4));
        System.err.println(new H_Index().solution(c5));
    }

    public int solution(int[] citations) {
        int answer = 0;

        // 역순 정렬
        List<Integer> list = new ArrayList<>();
        for (int c:citations) {
            list.add(c);
        }
        Collections.sort(list, Collections.reverseOrder());
        System.err.println(list);

        int curr = list.get(0);
        while(true){
            System.err.println(curr);
            int finalCurr = curr;
            if(list.stream().filter(s->s.intValue()>= finalCurr).count() >= curr){
                answer=curr;
                break;
            };
            curr--;
        }
        return answer;
    }
}
