package study_of_hell.프로그래머스.JSH.level3;

import java.util.Arrays;
import java.util.HashMap;

public class 다단계_칫솔_판매 {
    public static void main(String[] args) {
        String[] e1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                e2= {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] r1={"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                r2={"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] s1={"young", "john", "tod", "emily", "mary"},
                s2={"sam", "emily", "jaimie", "edward"};
        int[] a1={12, 4, 2, 5, 10}, a2={2, 3, 5, 4};
        System.err.println(solution(e1, r1, s1, a1));
        System.err.println(solution(e2, r2, s2, a2));
    }

    static String[] e;
    static String[] r;
    static int[] res;
    static String[] s;
    static int[] a;
    static HashMap<String, Integer> map;

    static void calculate(String seller, int amount){
        String name = seller;
        int allAmount = (amount * 100);

        while(!name.equals("-")){
            if(allAmount==0) break;
            int idx = map.get(name);
            int nextAmount = (int) (allAmount *0.1);
            res[idx]+=allAmount-nextAmount;
            name = r[idx];
            allAmount = nextAmount;
        }

    }

    static void pro(){
        for (int i = 0; i < s.length; i++) {
            calculate(s[i], a[i]);
        }
    }

    static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        e= enroll;
        r = referral;
        res = new int[enroll.length];
        map = new HashMap<>();
        s=seller;
        a=amount;
        for (int i = 0; i < enroll.length; i++) {
            res[i]=0;
            map.put(enroll[i], i);
        }

        pro();

        return res;
    }
}
