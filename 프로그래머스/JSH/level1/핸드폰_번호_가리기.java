package study_of_hell.프로그래머스.JSH.level1;

public class 핸드폰_번호_가리기 {
    public static void main(String[] args) {
        String p1 ="01033334444", p2="027778888";
        System.err.println(solution(p1));
        System.err.println(solution(p2));
    }

    public static String solution(String phone_number) {
        int length = phone_number.length();
        String newPhone = phone_number.substring(length-4, length);

        String answer="";
        for (int i = 0; i < length-4; i++) {
            answer+="*";
        }
        answer+=newPhone;

        return answer;
    }
}
