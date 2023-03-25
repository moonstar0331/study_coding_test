package programmers.Lv1;

public class DeckOfCards {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        int p1=0, p2=0;

        for(int i=0; i<goal.length; i++) {
            if(p1<cards1.length && p2<cards2.length) {
                if(!(goal[i].equals(cards1[p1])) && !(goal[i].equals(cards2[p2]))) {
                    return "No";
                }
                if(goal[i].equals(cards1[p1])) {
                    p1++;
                    continue;
                }
                if(goal[i].equals(cards2[p2])) {
                    p2++;
                    continue;
                }
            } else if (p1>=cards1.length) {
                if(goal[i].equals(cards2[p2])) {
                    p2++;
                    continue;
                } else {
                    return "No";
                }
            } else if(p2 >= cards2.length) {
                if(goal[i].equals(cards1[p1])) {
                    p1++;
                    continue;
                } else {
                    return "No";
                }
            }
        }

        return "Yes";
    }
}
