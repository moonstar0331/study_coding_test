package programmers.Lv1;

// Lv.1 - 공원 산책
public class WalkingPark {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int H = park.length;
        int W = park[0].length();

        String[][] parks = new String[H][W];
        int[] dirx = {-1, 0, 1, 0};
        int[] diry = {0, -1, 0, 1};

        int x = 0;
        int y = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                parks[i][j] = park[i].substring(j, j + 1);
                if(parks[i][j].equals("S")) {
                    x = j;
                    y = i;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String dir = routes[i].split(" ")[0];
            int num = Integer.parseInt(routes[i].split(" ")[1]);

            int idx = 0;
            if (dir.equals("N")) idx = 1;
            else if (dir.equals("E")) idx = 2;
            else if (dir.equals("S")) idx = 3;

            int dx = x;
            int dy = y;
            boolean success = true;
            for (int j = 1; j <= num; j++) {
                dx += dirx[idx];
                dy += diry[idx];

                if (dx < 0 || dy < 0 || dx >= W || dy >= H || parks[dy][dx].equals("X")) {
                    success = false;
                    continue;
                }
            }
            if (success) {
                x = dx;
                y = dy;
            }
        }

        answer[0] = y;
        answer[1] = x;

        return answer;
    }
}
