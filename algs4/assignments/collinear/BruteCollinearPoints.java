import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class BruteCollinearPoints {
    private List<LineSegment> segments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        checkCornerCases(points);

        this.segments = new ArrayList<>();
        Arrays.sort(points);

        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int m = j + 1; m < points.length - 1; m++) {
                    for (int n = m + 1; n < points.length; n++) {
                        if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[m])
                                && points[i].slopeTo(points[m]) == points[i].slopeTo(points[n])) {
                            segments.add(new LineSegment(points[i], points[n]));
                        }
                    }
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
