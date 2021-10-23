package study_of_hell.기타.JSH;

public class _211023_3 {
    public static void main(String[] args) {
        System.err.println(new _211023_3().solution(100));
        System.err.println(new _211023_3().solution(30));
    }

    public int solution(int size) {
        this.answer = 0;
        this.size = size;
        this.selected = new int[4];

        rec_func(this.size, 2);

        return this.answer;
    }

    static int size, answer;
    static int[] selected ;

    public void rec_func(int k, int count){
        if(count==0){
            if(k>=selected[2-count]) {
                selected[3] = k;
                if (canBeTriangle(selected[1], selected[2], selected[3])) {
                    answer++;
                }
            }
        }else{
            int start = selected[2-count];
            if(start==0) start = 1;
            for(int cand = start; cand<= k-count;cand++){
                selected[3-count] = cand;
                rec_func(k-cand, count-1);
                selected[3-count] = 0;
            }
        }

    }

    public boolean canBeTriangle(int a, int b, int c){
        if(a+b<=c || a+c<=b || b+c<=a)
            return false;
        return true;
    }
}
