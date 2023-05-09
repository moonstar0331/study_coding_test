import java.util.*;
class Solution {
    
    int[] dirx = {1, 0, -1, 0};
    int[] diry = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visit = new int[maps.length][maps[0].length];
        
        bfs(maps, visit);
        answer = visit[maps.length-1][maps[0].length-1];
        
        if(answer == 0) return -1;
        
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visit) {
        int x = 0;
        int y = 0;
        visit[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for(int i=0; i<4; i++) {
                int nextX = curX + dirx[i];
                int nextY = curY + diry[i];
                
                if(nextX<0||nextY<0||nextX>maps.length-1||nextY>maps[0].length-1) continue;
                
                if(visit[nextX][nextY] == 0 && maps[nextX][nextY]==1) {
                    visit[nextX][nextY] = visit[curX][curY] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}