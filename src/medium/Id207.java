package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Id207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// init graph
		List<LinkedList<Integer>> graph = Stream.generate(() -> new LinkedList<Integer>())
			.limit(numCourses)
			.collect(Collectors.toCollection(() -> new ArrayList<>()));

		// populate graph and init indegree
		int[] indegree = new int[numCourses];
		int from = 0, to = 0;
		for (int i = 0; i <= prerequisites.length - 1; i++) {
			from = prerequisites[i][1];
			to = prerequisites[i][0];

			graph.get(from)
				.add(to);
			indegree[to]++;
		}

		// populate q with source vertices
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i <= indegree.length - 1; i++) {
			if (indegree[i] == 0) {
				q.offerLast(i);
			}
		}

		Integer curr = 0;
		Integer preReqsTaken = 0;
		while (!q.isEmpty()) {
			curr = q.pollFirst();
			preReqsTaken++;

			for (Integer neighbor : graph.get(curr)) {
				if (indegree[neighbor] > 0) {
					indegree[neighbor]--;
				}
				if (indegree[neighbor] == 0) {
					q.offerLast(neighbor);
				}
			}
		}

		return preReqsTaken == numCourses;
	}
}
