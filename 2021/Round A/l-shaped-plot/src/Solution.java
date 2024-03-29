import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://codingcompetitions.withgoogle.com/kickstart/round/0000000000436140/000000000068c509
public class Solution {
    private static List<Segment> goodSegmentListInColumns;
    private static List<Segment> goodSegmentListInRows;

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {

            int t = sc.nextInt();
            for (int i = 1; i <= t; i++) {
                goodSegmentListInColumns = new ArrayList<>();
                goodSegmentListInRows = new ArrayList<>();
                int r = sc.nextInt();
                int c = sc.nextInt();
                if (r == 1 || c == 1) {
                    System.out.println("Case #" + i + ": 0");
                }
                int[][] arr = createArray(r, c, sc);
                findGoodSegment(arr);
                System.out.println("Case #" + i + ": " + findLShapes());
            }
        }
    }

    private static int[][] createArray(int r, int c, Scanner sc) {
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = sc.nextInt();
            }
        }
        return result;
    }

    private static void findGoodSegment(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                Segment goodSegment = new Segment();
                for (int k = j; k < grid.length; k++) {
                    if (grid[k][i] == 1) {
                        goodSegment.addPoint(new Point(k, i));
                        if (goodSegment.getLength() > 1) {
                            goodSegmentListInColumns.add(new Segment(goodSegment));
                        }
                    } else {
                        break;
                    }
                }
                goodSegment = new Segment();
                for (int k = i; k < grid[0].length; k++) {
                    if (grid[j][k] == 1) {
                        goodSegment.addPoint(new Point(j, k));
                        if (goodSegment.getLength() > 1) {
                            goodSegmentListInRows.add(new Segment(goodSegment));
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private static int findLShapes() {
        int lShapesAmount = 0;
        for (Segment segmentColumn : goodSegmentListInColumns) {
            for (Segment segmentRow : goodSegmentListInRows) {
                if (segmentColumn.getLength() * 2 == segmentRow.getLength() ||
                        segmentRow.getLength() * 2 == segmentColumn.getLength()) {
                    if (segmentColumn.getFirstPoint().equals(segmentRow.getFirstPoint()) ||
                            segmentColumn.getFirstPoint().equals(segmentRow.getLastPoint()) ||
                            segmentColumn.getLastPoint().equals(segmentRow.getFirstPoint()) ||
                            segmentColumn.getLastPoint().equals(segmentRow.getLastPoint())) {
                        lShapesAmount++;
                    }
                }
            }
        }

        return lShapesAmount;
    }

    private static class Point {
        private int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object obj) {
            return x == ((Point) obj).getX() && y == ((Point) obj).getY();
        }
    }

    private static class Segment {
        private List<Point> points;
        private int length;

        Segment() {
            points = new ArrayList<>();
        }

        Segment(Segment segment) {
            this.points = new ArrayList<>(segment.points);
            this.length = segment.length;
        }

        void addPoint(Point point) {
            points.add(point);
            length = points.size();
        }

        int getLength() {
            return this.length;
        }

        Point getFirstPoint() {
            if (points.size() > 0) {
                return points.get(0);
            } else {
                return null;
            }
        }

        Point getLastPoint() {
            if (points.size() > 0) {
                return points.get(points.size() - 1);
            } else {
                return null;
            }
        }
    }

}
