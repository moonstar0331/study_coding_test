import java.util.*;
class Solution {
    
    static int[][] adj;
    
    public int solution(int n, int[][] wires) {
        // n개의 송전탑이 전선을 통해 하나의 트리 형태
        // 전선들 중 하나를 끝어서 2개로 분할
        // 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게
        // return: 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)
        
        int answer = Integer.MAX_VALUE;
        adj = new int[n+1][n+1];
        
        for(int i=0; i<wires.length; i++) {
            int p1 = wires[i][0];
            int p2 = wires[i][1];
            adj[p1][p2] = 1;
            adj[p2][p1] = 1;
        }
        
        for(int i=0; i<wires.length; i++) {
            int[] tmp = wires[i];
            
            // 전선 삭제
            adj[tmp[0]][tmp[1]] = 0;
            adj[tmp[1]][tmp[0]] = 0;
            
            // 송전탑 개수 확인
            int num1 = bfs(tmp[0], n);
            int num2 = bfs(tmp[1], n);
            answer = Math.min(answer, Math.abs(num1 - num2));
            
            // 전선 다시 추가
            adj[tmp[0]][tmp[1]] = 1;
            adj[tmp[1]][tmp[0]] = 1;
        }
        
        return answer;
    }
    
    public static int bfs(int v, int n) {
        boolean[] visit = new boolean[n+1];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;
        int cnt = 1;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            
            for(int y=1; y<=n; y++) {
                if(adj[x][y] == 0) continue;
                if(visit[y]) continue;
                
                q.add(y);
                visit[y] = true;
                cnt++;
            }
        }
        return cnt;
    }
}