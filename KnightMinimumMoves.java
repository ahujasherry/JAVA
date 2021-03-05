package com.sherry.ds;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int x;
	int y;
	int distace;

	public Node(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distace = distance;
	}
}

public class KnightMinMoves {
	public static boolean isSafe(int x, int y, int N) {
		if (x >= 1 && x <= N && y >= 1 && y <= N)
			return true;
		return false;
	}

	public static int minStepToReachTarget(int start[], int target[], int N) {
		Queue<Node> q = new LinkedList();
		boolean visited[][] = new boolean[N + 1][N + 1];

		int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
		int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

		Node temp = new Node(start[0], start[1], 0);
		q.add(temp);
		visited[start[0]][start[1]] = true;

		while (q.isEmpty() == false) {
			Node front = q.peek();
			q.remove();

			if (front.x == target[0] && front.y == target[1]) {
				return front.distace;
			}

			for (int i = 0; i < 8; i++) {
				int nextX = front.x + dx[i];
				int nextY = front.y + dy[i];

				if (isSafe(nextX, nextY, N) == true && visited[nextX][nextY] == false) {
					q.add(new Node(nextX, nextY, front.distace + 1));
					visited[nextX][nextY] = true;
				}

			}

		}

		return -1;
	}

	public static void main(String[] args) {
		int N = 30;
		int knightPos[] = { 1, 1 };
		int targetPos[] = { 30, 30 };
		System.out.println(minStepToReachTarget(knightPos, targetPos, N));
	}

}
