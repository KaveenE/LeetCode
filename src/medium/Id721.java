package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Id721 {
	/*
	 * 1. Create graph where emails are vertices and neighbors areneighbor emails.
	 * 2. Modify counting components algo i. Add List<String> (which will be updated
	 *    during traversal of a component) into List<List<String>> instead of incrementing count of component
	 */
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		// emails=vertices. Neighbors=emails emails.
		Map<String, Set<String>> graph = new HashMap<>();
		Map<String, String> emailToName = new HashMap<>();
		String name;

		for (List<String> account : accounts) {
			name = account.get(0);
			for (int idx = 1; idx <= account.size() - 1; idx++) {
				graph.computeIfAbsent(account.get(idx), _x -> new HashSet<>());

				// populate my UD graph
				if (idx != 1) {
					graph.get(account.get(idx))
						.add(account.get(idx - 1));
					graph.get(account.get(idx - 1))
						.add(account.get(idx));
				}

				emailToName.computeIfAbsent(account.get(idx), _x -> account.get(0));
			}
		}

		return traverse(graph, emailToName);
	}

	public List<List<String>> traverse(Map<String, Set<String>> graph, Map<String, String> emailToName) {
		Set<String> visited = new HashSet<>();
		List<List<String>> updatedAccounts = new ArrayList<>();
		List<String> updatedAccount = new LinkedList<>();

		for (String email : emailToName.keySet()) {
			if (!visited.contains(email)) {
				dfs(graph, email, visited, updatedAccount);

				Collections.sort(updatedAccount);
				updatedAccount.add(0, emailToName.get(email));
				updatedAccounts.add(updatedAccount);

				updatedAccount = new LinkedList<>();
			}
		}

		return updatedAccounts;
	}

	public void bfs(Map<String, Set<String>> graph, String srcEmail, Set<String> visited, List<String> updatedAccount) {
		Deque<String> dq = new ArrayDeque<>();
		dq.offerLast(srcEmail);
		visited.add(srcEmail);

		String currVertex;

		while (!dq.isEmpty()) {
			currVertex = dq.pollFirst();
			updatedAccount.add(currVertex);

			for (String neighbor : graph.get(currVertex)) {
				if (visited.add(neighbor)) {
					dq.offerLast(neighbor);
				}
			}
		}
	}

	public void dfs(Map<String, Set<String>> graph, String srcEmail, Set<String> visited, List<String> updatedAccount) {
		visited.add(srcEmail);
		updatedAccount.add(srcEmail);

		for (String neighbor : graph.get(srcEmail)) {
			if (visited.add(neighbor)) {
				dfs(graph, neighbor, visited, updatedAccount);
			}
		}
	}
}
