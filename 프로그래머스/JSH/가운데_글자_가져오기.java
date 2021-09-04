package study_of_hell.프로그래머스.JSH;

//문제 설명
//        단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
//
//        재한사항
//        s는 길이가 1 이상, 100이하인 스트링입니다.
//        입출력 예
//        s	return
//        "abcde"	"c"
//        "qwer"	"we"

public class 가운데_글자_가져오기 {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "qwer";

        System.err.println(solution(s1));
        System.err.println(solution(s2));
    }

    public static String solution(String s){
        int meanLength=s.length()/2;

        String answer = s.substring((s.length()%2==0?meanLength-1: meanLength), meanLength+1);

        return answer;
    }
}
