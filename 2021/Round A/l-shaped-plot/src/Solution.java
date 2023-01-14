import java.util.ArrayList;
import java.util.List;
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
                List<List<Solution.Point>> goodSegmentList = findGoodSegment(arr);

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

    private static List<List<Point>> findGoodSegment(int[][] grid) {
        List<List<Point>> goodSegmentsList = new ArrayList<>();

        // Going along X -> axis
        for(int i = 0; i < grid[0].length; i++) {
            for(int j = 0; j < grid.length; j++) {
                List<Point> goodSegment = new ArrayList<>();
                for (int k = j; k < grid.length; k++) {
                    if(grid[k][i] == 1) {
                        goodSegment.add(new Point(k, i));
                        if(goodSegment.size() > 1) {
                            goodSegmentsList.add(new ArrayList<>(goodSegment));
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return goodSegmentsList;
    }

    private static class Point {
        private int x,y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    
}
