package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Id973 {
	public int[][] kClosest_sort(int[][] points, int k) {
		List<Point> sortedPoints = new ArrayList<>();

		for (int[] point : points) {
			sortedPoints.add(new Point(point[0], point[1]));
		}

		Collections.sort(sortedPoints);
		int[][] closetPoints = new int[k][2];

		for (int i = 0; i <= k - 1; i++) {
			closetPoints[i][0] = sortedPoints.get(i).x;
			closetPoints[i][1] = sortedPoints.get(i).y;
		}

		return closetPoints;
	}

	public int[][] kClosest_heap(int[][] points, int k) {
		PriorityQueue<Point> pq = new PriorityQueue<>();

		for (int[] point : points) {
			pq.offer(new Point(point[0], point[1]));
		}

		int[][] closetPoints = new int[k][2];
		Point curr;
		for (int i = 0; i <= k - 1; i++) {
			curr = pq.poll();
			closetPoints[i][0] = curr.x;
			closetPoints[i][1] = curr.y;
		}

		return closetPoints;
	}

	
}

class Point implements Comparable<Point> {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		Point origin = new Point(0, 0);
		return Double.compare(euclidean(this, origin), euclidean(o, origin));
	}

	public static double euclidean(Point p1, Point p2) {
		double x_diff_sqr = Math.pow(p1.x - p2.x, 2);
		double y_diff_sqr = Math.pow(p1.y - p2.y, 2);

		return Math.sqrt(x_diff_sqr + y_diff_sqr);
	}

}