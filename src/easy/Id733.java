package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Id733 {
	public int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
		boolean[][] visited = new boolean[image.length][image[0].length];

		Deque<Node> queue = new ArrayDeque<>();

		Node currNode = new Node(sr, sc);
		queue.offerLast(currNode);
		visited[sr][sc] = true;

		int srcPixel = image[sr][sc];
		while (!queue.isEmpty()) {
			currNode = queue.pollFirst();
			image[currNode.row][currNode.col] = color;

			for (Node neighbor : neighbours(currNode, image)) {

				if (!visited[neighbor.row][neighbor.col] && isSamePixelAsSrc(image, neighbor, srcPixel)) {
					visited[neighbor.row][neighbor.col] = true;
					queue.offerLast(neighbor);
				}
			}
		}

		return image;
	}

	public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
		boolean[][] visited = new boolean[image.length][image[0].length];

		Node currNode = new Node(sr, sc);
		int srcPixel = image[sr][sc];

		floodFillDFSRec(image, currNode, color, srcPixel, visited);

		return image;
	}

	private void floodFillDFSRec(int[][] image, Node currNode, int color, int srcPixel, boolean[][] visited) {
		visited[currNode.row][currNode.col] = true;
		image[currNode.row][currNode.col] = color;

		for (Node neighbor : neighbours(currNode, image)) {

			if (!visited[neighbor.row][neighbor.col] && isSamePixelAsSrc(image, neighbor, srcPixel)) {
				floodFillDFSRec(image, neighbor, color, srcPixel, visited);
			}
		}
	}

	private boolean isSamePixelAsSrc(int[][] image, Node curr, int srcPixel) {
		return image[curr.row][curr.col] == srcPixel;
	}

	private List<Node> neighbours(Node curr, int[][] image) {
		List<Node> neighbours = new ArrayList<>();

		if ((curr.row - 1) >= 0) {
			neighbours.add(new Node(curr.row - 1, curr.col));
		}

		if ((curr.row + 1) <= image.length - 1) {
			neighbours.add(new Node(curr.row + 1, curr.col));
		}

		if ((curr.col - 1) >= 0) {
			neighbours.add(new Node(curr.row, curr.col - 1));
		}

		if ((curr.col + 1) <= image[0].length - 1) {
			neighbours.add(new Node(curr.row, curr.col + 1));
		}

		return neighbours;
	}

	private class Node {
		int row;
		int col;

		Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
