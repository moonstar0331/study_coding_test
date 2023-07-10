class Solution {
    public int[] solution(int[] sequence, int k) {
        int sum = 0;
        int lt = 0;
        int rt = -1;
        int size = sequence.length;
        int[] answer = new int[]{0, size};
        
        while(true) {
            if(sum <= k) {
                if(sum == k && answer[1] - answer[0] > rt-lt) {
                    answer = new int[]{lt, rt};
                }
                rt++;
                if(rt >= size) break;
                sum += sequence[rt];
            } else {
                sum -= sequence[lt++];
            }
        }
        return answer;
    }
}