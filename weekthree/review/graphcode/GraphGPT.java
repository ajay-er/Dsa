package graphcode;

import java.util.*;


public class GraphGPT {
    private int V;
    private ArrayList<Integer>[] adjList;

    public GraphGPT(int V) {
        this.V = V;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    public void removeEdge(int u, int v) {
        adjList[u].remove((Integer) v);
        adjList[v].remove((Integer) u);
    }

    public void addVertex() {
        V++;
        ArrayList<Integer> newList = new ArrayList<Integer>();
        adjList = Arrays.copyOf(adjList, V);
        adjList[V-1] = newList;
    }

    public void removeVertex(int v) {
        V--;
        adjList[v] = null;
        for (int i = 0; i < V; i++) {
            if (adjList[i].contains(v)) {
                adjList[i].remove((Integer) v);
            }
        }
        adjList = Arrays.copyOf(adjList, V);
    }



     public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (int adj : adjList[curr]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.offer(adj);
                }
            }
        }
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[V];
        dfsHelper(start, visited);
    }

    private void dfsHelper(int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");

        for (int adj : adjList[curr]) {
            if (!visited[adj]) {
                dfsHelper(adj, visited);
            }
        }
    }



}
