import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        
        
        for(int i=0; i<records.length; i++) {
            String[] info = records[i].split(" ");
            String[] timeArr = info[0].split(":");
            int time = Integer.parseInt(timeArr[0])*60 + Integer.parseInt(timeArr[1]);
            String num = info[1];
            String io = info[2];
            
            if(io.equals("IN")) {
                map.put(num, time);
            } else {
                timeMap.put(num, timeMap.getOrDefault(num, 0) + time-map.get(num));
                map.remove(num);
            }
        }
        
        if(!map.isEmpty()) {
            for(String key : map.keySet()) {
                timeMap.put(key, timeMap.getOrDefault(key, 0) + 23*60+59-map.get(key));
            }
        }
        
        List<String> keyList = new ArrayList<>(timeMap.keySet());
        keyList.sort((o1, o2) -> o1.compareTo(o2));
        
        List<Integer> money = new ArrayList<>();
        
        for(String key : keyList) {
            int tmp = timeMap.get(key) - fees[0];
            if(tmp <= 0) money.add(fees[1]);
            else {
                int fee = 0;
                if(tmp%fees[2]==0) fee = fees[1] + tmp/fees[2]*fees[3];
                else fee = fees[1] + (tmp/fees[2]+1)*fees[3];
                money.add(fee);
            }
        }
        int[] answer = new int[money.size()];
        for(int i=0; i<money.size(); i++) {
            answer[i] = money.get(i);
        }
        
        return answer;
    }
}