package study_of_hell.프로그래머스.JSH.level2;

public class 큰_수_만들기 {
    public static void main(String[] args) {
        System.err.println(solution("1924", 2));
        System.err.println(solution("1231234", 3));
        System.err.println(solution("4177252841", 4));
    }


    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int idx = 0;
        int comp = 0;
        for(int i=0; i<number.length()-k; i++){
            comp = 0;
            for(int j=idx; j<=i+k; j++){
                if(comp < number.charAt(j)-'0'){
                    comp = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            answer.append(comp);
        }
        return answer.toString();
    }
}
