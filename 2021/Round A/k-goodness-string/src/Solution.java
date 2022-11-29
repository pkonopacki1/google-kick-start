import java.util.Scanner;

// https://codingcompetitions.withgoogle.com/kickstart/round/0000000000436140/000000000068cca3#problem

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            StringBuffer sb = new StringBuffer();
            int t = sc.nextInt();
            for(int i = 1; i <= t; i++) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                String s = sc.next();
                
                int score = Math.abs(k - goodnesScore(s));

                System.out.println("Case #" + i + ": " + score);
            }
        }
    }

    private static int goodnesScore(String string) {
        int score = 0;
        for(int i = 0; i < string.length()/2; i++) {
            if(string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                score++;
            }
        }
        return score;
    }
}
