package medium;

import java.util.ArrayList;
import java.util.List;

public class Id54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		// if (matrix == null || matrix.length == 0) return res;
		int row = matrix.length, col = matrix[0].length;
		int rowStart = 0, rowEnd = row - 1;
		int colStart = 0, colEnd = col - 1;
		
		while (res.size() < row * col) {
			for (int j = colStart; j <= colEnd && res.size() < row * col; j++)
				res.add(matrix[rowStart][j]);

			for (int i = rowStart + 1; i <= rowEnd - 1 && res.size() < row * col; i++)
				res.add(matrix[i][colEnd]);

			for (int j = colEnd; j >= colStart && res.size() < row * col; j--)
				res.add(matrix[rowEnd][j]);

			for (int i = rowEnd - 1; i >= rowStart + 1 && res.size() < row * col; i--)
				res.add(matrix[i][colStart]);

			colStart++;
			colEnd--;
			rowStart++;
			rowEnd--;
		}
		return res;
	}
}
