package programmers.Lv1;

// Lv.1 - 카카오 블라인드 채용 - [1차] 다트 게임
public class Kakao_DartGame {
    public int solution(String dartResult) {
        int answer = 0;

        String[] dart = dartResult.split("");
        int[] score = new int[3];

        int index = -1;
        for(int i=0; i<dart.length; i++) {
            if(dart[i].matches("[0-9]")) {
                index++;
                score[index] = Integer.parseInt(dart[i]);
                if(dart[i+1].matches("[0-9]")) {
                    score[index] = 10;
                    i++;
                }
                continue;
            }

            switch(dart[i]) {
                case "D":
                    score[index] = (int)Math.pow(score[index],2);
                    break;
                case "T":
                    score[index] = (int)Math.pow(score[index],3);
                    break;
                case "*":
                    score[index] *= 2;
                    if(index-1>=0) score[index-1] *=2;
                    break;
                case "#":
                    score[index] *= -1;
            }
        }

        for(int s : score) {
            answer += s;
        }

        return answer;
    }
}
