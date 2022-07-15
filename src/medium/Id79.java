package medium;

import java.util.ArrayList;
import java.util.List;

//Complexity = O(time to load up source * backtrack)
//=O(MN * braching factor^height of tree)
//=(MN * 4^size of word)
public class Id79 {
	int[][] DIR_TO_MOVE = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public boolean exist(char[][] board, String word) {

		boolean[][] vertexOnStack = new boolean[board.length][board[0].length];

		// Multi source DFS with source == first letter of word
		for (int row = 0; row <= board.length - 1; row++) {
			for (int col = 0; col <= board[row].length - 1; col++) {
				if (board[row][col] == word.charAt(0) && backtrack(board, vertexOnStack, row, col, 0, word)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean backtrack(char[][] board, boolean[][] vertexOnStack, int srcRow, int srcCol, int idx, String word) {
		if (idx == word.length())
			return true;

		// Prune invalid nodes
		if (srcRow < 0 || srcRow > board.length - 1 || srcCol < 0 || srcCol > board[srcRow].length - 1)
			return false;
		if (word.charAt(idx) != board[srcRow][srcCol])
			return false;
		if (vertexOnStack[srcRow][srcCol])
			return false;

		vertexOnStack[srcRow][srcCol] = true;
		for (int[] neighbor : neighbors(board, srcRow, srcCol)) {
			if (backtrack(board, vertexOnStack, neighbor[0], neighbor[1], idx + 1, word))
				return true;
		}
		vertexOnStack[srcRow][srcCol] = false;

		return false;

	}

	private List<int[]> neighbors(char[][] board, int srcRow, int srcCol) {
		List<int[]> neighbors = new ArrayList<>();

		for (int i = 0; i <= DIR_TO_MOVE.length - 1; i++) {
			neighbors.add(new int[] { srcRow + DIR_TO_MOVE[i][0], srcCol + DIR_TO_MOVE[i][1] });
		}

		return neighbors;
	}
}
