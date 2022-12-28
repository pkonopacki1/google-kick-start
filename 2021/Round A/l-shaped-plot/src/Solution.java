import java.util.Scanner;

//https://codingcompetitions.withgoogle.com/kickstart/round/0000000000436140/000000000068c509

//todo: actual logic

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {

            int t = sc.nextInt();
            for (int i = 1; i <= t; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                if(r == 1 || c == 1) {
                    System.out.println("Case #" + i + ": 0" );
                }
                int[][] arr = createArray(r, c, sc);         

            }
            System.out.println("end");
        }
    }

    private static int[][] createArray(int r, int c, Scanner sc) {
        int[][] result = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                result[i][j] = sc.nextInt();
            }
        }

        return result;
    }

    
}
