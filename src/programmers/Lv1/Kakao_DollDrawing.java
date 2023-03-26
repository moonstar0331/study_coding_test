package programmers.Lv1;

import java.util.*;

public class Kakao_DollDrawing {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<moves.length; i++) {
            int boardCol = moves[i] - 1;
            for(int row=0; row<board.length; row++) {
                if(board[row][boardCol]==0) continue;
                else {
                    if(!stack.isEmpty()) {
                        if(stack.peek() == board[row][boardCol]) {
                            answer+=2;
                            stack.pop();
                            board[row][boardCol] = 0;
                            break;
                        } else {
                            stack.push(board[row][boardCol]);
                            board[row][boardCol] = 0;
                            break;
                        }
                    } else {
                        stack.push(board[row][boardCol]);
                        board[row][boardCol] = 0;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
