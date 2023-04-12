class Solution {

    static int answer = 0;

    public static void cal(int k, int cur, int target, int[] numbers) {
        if(k == numbers.length) {
            if(cur == target) answer++;
        } else {
            cal(k+1, cur-numbers[k], target, numbers);
            cal(k+1, cur+numbers[k], target, number);
        }
    }

    public int solution(int[] priorities, int location) {

        cal(0, 0, target, numbers);
        
        return answer;
    }
}