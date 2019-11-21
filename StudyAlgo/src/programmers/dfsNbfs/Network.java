package programmers.dfsNbfs;

public class Network {
	static boolean[] visit;

	public int solution(int n, int[][] computers) {
		int answer = 0;
		visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				answer++;
				dfs(computers, i, n); // i:startNode, n:node갯수
			}
		}
		return answer;
	}

	public static void dfs(int[][] computers, int idx, int n) {
		visit[idx] = true; // 방문한 노드
		for (int i = 0; i < n; i++) {
			if (computers[idx][i] == 1 && !visit[i]) {
				dfs(computers, i, n);
			}
		}
	}

}
