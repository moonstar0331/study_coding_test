import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String> () {
            @Override
            public int compare(String s1, String s2) {
                String head1 = s1.split("[0-9]")[0];
                String head2 = s2.split("[0-9]")[0];
                int compareHead = head1.toLowerCase().compareTo(head2.toLowerCase());
                
                if(compareHead == 0) {
                    s1 = s1.substring(head1.length());
                    s2 = s2.substring(head2.length());
                    String number1 = "";
                    for(char x : s1.toCharArray()) {
                        if(Character.isDigit(x) && number1.length() <= 5)
                            number1 += x;
                        else break;
                    }
                    String number2 = "";
                    for(char x : s2.toCharArray()) {
                        if(Character.isDigit(x) && number2.length() <= 5)
                            number2 += x;
                        else break;
                    }
                    return Integer.parseInt(number1) - Integer.parseInt(number2);
                } else {
                    return compareHead;
                }
            }
        });
        return files;
    }
}