import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FastCollinearPoints {
    private List<LineSegment> segments;

    // finds all line segments containing 4 points
    public FastCollinearPoints(Point[] points) {
        checkCornerCases(points);

        this.segments = new ArrayList<>();

        for (int i = 0; i < points.length - 3; i++) {
            // de-dpuplicate
            Arrays.sort(points, i, points.length);

            // sort all following points according to slope with current point
            Arrays.sort(points, i + 1, points.length, points[i].slopeOrder());

            // find every group and check whether it is a line segment
            int countEqual = 2;
            double currentSlope = points[i].slopeTo(points[i + 1]);
            for (int j = i + 2; j < points.length; j++) {
                if (currentSlope == points[i].slopeTo(points[j])) {
                    countEqual++;
                } else {
                    if (countEqual >= 4) {
                        segments.add(new LineSegment(points[i], points[j - 1]));
                    }
                    countEqual = 2;
                    currentSlope = points[i].slopeTo(points[j]);
                }
                if (j == points.length - 1 && countEqual >= 4) {
                    segments.add(new LineSegment(points[i], points[j]));
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.size();
    }

    // the line segments
    public LineSegment[] segments() {

        return segments.toArray(new LineSegment[segments.size()]);
    }

    private void checkCornerCases(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException();

        for (Point p : points)
            if (p == null)
                throw new IllegalArgumentException();

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0)
                    throw new IllegalArgumentException();
            }
        }
    }
}
