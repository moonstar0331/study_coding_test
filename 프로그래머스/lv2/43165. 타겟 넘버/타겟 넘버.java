class Solution {
    
    static int answer = 0;
    
    public static void cal(int k, int cur, int target, int[] numbers) {
        if(k == numbers.length) {
            if(cur == target) answer++;
        } else {
            cal(k+1, cur-numbers[k], target, numbers);
            cal(k+1, cur+numbers[k], target, numbers);
        }
    }
    
    public int solution(int[] numbers, int target) {
        
        // n 개의 음이 아닌 정수들
        // 순서를 바꾸지 않고 적절히 더하거나 빼서 타켓 넘버 만들기
        // 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수 return
        cal(0, 0, target, numbers);
        cal(0, 0, target, numbers);
        
        return answer/2;
    }
}