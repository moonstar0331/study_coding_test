import java.util.*;
class Solution {
    
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer> list = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        map = new char[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(!visited[i][j] && map[i][j] != 'X') {
                    list.add(bfs(i, j));
                }
            }
        }
        
        if(list.size() == 0) return new int[]{-1};
        
        int[] answer = new int[list.size()];
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public static int bfs(int x, int y) {
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            sum += map[cx][cy] - '0';
            
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx<0 || ny<0 || nx>=map.length || ny>=map[0].length) continue;
                if(!visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return sum;
    }
}