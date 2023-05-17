class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] % 2 == 0) answer[i] = numbers[i] + 1;
            else {
                String bit = Long.toString(numbers[i], 2);
                int zeroIdx = bit.lastIndexOf("0");
                if(zeroIdx != -1) {
                    bit = bit.substring(0, zeroIdx) + "10" + bit.substring(zeroIdx+2, bit.length());
                    answer[i] = Long.parseLong(bit, 2);
                } else {
                    bit = "10" + bit.substring(1, bit.length());
                    answer[i] = Long.parseLong(bit, 2);
                }
            }
        }
        
        return answer;
    }
}