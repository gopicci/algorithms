import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {

    private ArrayList<LineSegment> segmentsList = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {
        if (points == null || points.length < 4) throw new IllegalArgumentException();

        Point[] pcopy = points.clone();

        Arrays.sort(pcopy);

        for (int i = 0; i < pcopy.length - 1; i++)
            if (pcopy[i].compareTo(pcopy[i + 1]) == 0 || pcopy[i] == null) throw new IllegalArgumentException();

        int n = pcopy.length;

        for (int p = 0; p < n-3; p++) {
            Arrays.sort(pcopy);
            Arrays.sort(pcopy, pcopy[p].slopeOrder());

            for (int i = 0, first = 1, last = 2; last < n; last++) {

                while (last < n && Double.compare(pcopy[i].slopeTo(pcopy[first]), pcopy[i].slopeTo(pcopy[last])) == 0)
                    last++;

                if (last - first >= 3 && pcopy[i].compareTo(pcopy[first]) < 0)
                    segmentsList.add(new LineSegment(pcopy[i], pcopy[last - 1]));

                first = last;

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