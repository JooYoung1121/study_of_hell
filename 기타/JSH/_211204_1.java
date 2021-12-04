package study_of_hell.기타.JSH;

public class _211204_1 {
    public static void main(String[] args) {
        String[] drum ={"######",">#*###","####*#","#<#>>#",">#*#*<","######"};
        System.err.println(solution(drum));
    }

    static String[] d;
    static int meetStar; // *을 만난 횟수
    static int answer;

    /**
     * start위치에서 구슬을 떨어뜨리기
     * @param start
     */
    static void dropMarble(int start){
        meetStar = 0;
        int nx = 0;
        int ny = start;

        while(true){
            char sign = d[nx].charAt(ny);

            switch(sign){
                case '#':   // 아래로 한칸
                    nx+=1; break;
                case '>':   // 오른쪽 한칸
                    ny+=1; break;
                case '<':   // 왼쪽 한칸
                    ny-=1; break;
                case '*':   // 아래로 한칸
                    nx+=1; meetStar++;break;
            }

            if(meetStar==2) break;  // *을 두번 만나면
            if(nx>=d.length) break;    // 구슬이 맨 아래로 떨어지면
        }

        if(meetStar!=2) answer++;
    }

    public static int solution(String[] drum) {
        d = new String[drum.length];
        answer = 0;

        for (int i = 0; i < d.length; i++) {
            d[i] = drum[i];
        }

        for (int i = 0; i < d.length; i++) {
            dropMarble(i);
        }

        return answer;
    }
}
