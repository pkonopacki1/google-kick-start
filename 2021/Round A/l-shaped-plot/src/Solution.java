import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://codingcompetitions.withgoogle.com/kickstart/round/0000000000436140/000000000068c509
//todo: actual logic
public class Solution {
    private static List<List<Solution.Point>> goodSegmentListInColumns = new ArrayList<>();
    private static List<List<Solution.Point>> goodSegmentListInRows = new ArrayList<>();

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
                findGoodSegment(arr);

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

    private static void findGoodSegment(int[][] grid) {
        for(int i = 0; i < grid[0].length; i++) {
            for(int j = 0; j < grid.length; j++) {
                List<Point> goodSegment = new ArrayList<>();
                for (int k = j; k < grid.length; k++) {
                    if(grid[k][i] == 1) {
                        goodSegment.add(new Point(k, i));
                        if(goodSegment.size() > 1) {
                            goodSegmentListInColumns.add(new ArrayList<>(goodSegment));
                        }
                    } else {
                        break;
                    }
                }
                goodSegment = new ArrayList<>();
                for (int k = i; k < grid[0].length; k++) {
                    if(grid[j][k] == 1) {
                        goodSegment.add(new Point(j, k));
                        if(goodSegment.size() > 1) {
                            goodSegmentListInRows.add(new ArrayList<>(goodSegment));
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private static class Point {
        private int x,y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    
}
