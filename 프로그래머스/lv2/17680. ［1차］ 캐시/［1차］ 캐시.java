import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) return cities.length * 5;
        
        // 캐시 교체 알고리즘은 LRU
        // cache hit : 실행시간 1
        // cache miss : 실행시간 5
        
        // 도시 이름을 저장할 cache
        ArrayList<String> cache = new ArrayList<>();
        
        // 각 도시이름 for문
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            if(cache.contains(city)){
                answer += 1; // cache 에 도시가 있다면 실행시간 1
                cache.remove(city);
                cache.add(city); // cache 에서 가장 최근 사용으로 갱신
            } else {
                answer += 5; // cache 에 도시가 없다면 실행시간 5
                if(cache.size() < cacheSize) {
                    cache.add(city); // cache의 사이즈가 cacheSize 보다 작다면 그냥 추가
                } else {
                    cache.remove(0); // cache의 사이즈가 cacheSize 보다 크다면 가장 오래된 도시 삭제
                    cache.add(city);
                }
            }
        }
        return answer;
    }
}