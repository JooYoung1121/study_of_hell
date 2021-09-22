package study_of_hell.프로그래머스.JSH.level1;

public class 소수_만들기 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4}, nums2={1,2,7,6,4};
        System.err.println(solution(nums1));
        System.err.println(solution(nums2));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length ; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if(checkSosu(num))
                        answer++;
                }
            }
        }
        return answer;
    }

    public static boolean checkSosu(int num){
        if(num%2==0)
            return false;

        for (int i = 3; i <=num/2; i++) {
            if(num%i==0)
                return false;
        }

        return true;
    }
}
