package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//Multi source BFS with the nodes of value 0
public class Id542 {
	private int[][] DIR_TO_MOVE = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, };

	public int[][] updateMatrix(int[][] mat) {
		Set<Node> visited = new HashSet<>();
		Node curr;

		Deque<Node> dq = new ArrayDeque<>();

		for (int row = 0; row <= mat.length - 1; row++) {
			for (int col = 0; col <= mat[row].length - 1; col++) {
				if (mat[row][col] == 0) {
					curr = new Node(row, col);
					dq.offerLast(curr);
					visited.add(curr);
				}
			}
		}

		while (!dq.isEmpty()) {
			curr = dq.pollFirst();

			for (Node neighbor : neighbors(mat, curr)) {

				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					mat[neighbor.row][neighbor.col] = mat[curr.row][curr.col] + 1;
					dq.offerLast(neighbor);
				}
			}
		}

		return mat;
	}

	private List<Node> neighbors(int[][] src, Node node) {
		List<Node> neighbors = new ArrayList<>();
		int neighborRow = 0;
		int neighborCol = 0;

		for (int i = 0; i <= DIR_TO_MOVE.length - 1; i++) {
			neighborRow = node.row + DIR_TO_MOVE[i][0];
			neighborCol = node.col + DIR_TO_MOVE[i][1];

			if (neighborRow >= 0 && neighborRow <= src.length - 1 && neighborCol >= 0
					&& neighborCol <= src[neighborRow].length - 1) {
				neighbors.add(new Node(neighborRow, neighborCol));
			}
		}
		return neighbors;
	}

	private class Node {
		public int row;
		public int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Node other = (Node) obj;
			if (col != other.col) {
				return false;
			}
			if (row != other.row) {
				return false;
			}
			return true;
		}

	}
}
