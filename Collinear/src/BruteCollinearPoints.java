import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    private ArrayList<LineSegment> segmentsList = new ArrayList<>();

    public BruteCollinearPoints(Point[] points) {
        if (points == null || points.length < 4) throw new IllegalArgumentException();

        int n = points.length;

        Point[] pcopy = points.clone();

        Arrays.sort(pcopy);

        for (int i = 0; i < pcopy.length - 1; i++)
            if (pcopy[i].compareTo(pcopy[i + 1]) == 0 || pcopy[i] == null) throw new IllegalArgumentException();

        for (int p = 0; p < n - 3; p++) {
            for (int q = p + 1; q < n - 2; q++) {
                for (int r = q + 1; r < n - 1; r++) {
                    for (int s = r + 1; s < n; s++) {
                        if (Double.compare(pcopy[p].slopeTo(pcopy[q]), pcopy[p].slopeTo(pcopy[r])) == 0 &&
                                Double.compare(pcopy[p].slopeTo(pcopy[q]), pcopy[p].slopeTo(pcopy[s])) == 0) {
                            segmentsList.add(new LineSegment(pcopy[p], pcopy[s]));
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments() {
        return segmentsList.size();
    }

    public LineSegment[] segments() {
        return segmentsList.toArray(new LineSegment[segmentsList.size()]);
    }

}