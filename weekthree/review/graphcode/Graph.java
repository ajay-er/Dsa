package graphcode;

import java.util.*;

public class Graph {
    private int V;  // number of vertices
    private LinkedList<Integer>[] adjList;  // adjacency list for each vertex
    
    // constructor
    public Graph(int v) {
        V = v;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    
    // method to add a vertex to the graph
    public void addVertex(int v) {
        if (v >= V) {
            LinkedList<Integer>[] newAdjList = new LinkedList[v + 1];
            System.arraycopy(adjList, 0, newAdjList, 0, V);
            for (int i = V; i <= v; i++) {
                newAdjList[i] = new LinkedList<>();
            }
            adjList = newAdjList;
            V = v + 1;
        }
    }
    
    // method to add an edge to the graph
    public void addEdge(int u, int v) {
        if (u < V && v < V) {
            adjList[u].add(v);
        }
    }
    
    // method to remove a vertex from the graph
    public void removeVertex(int v) {
        if (v < V) {
            adjList[v].clear();
            for (int i = 0; i < V; i++) {
                adjList[i].remove((Integer) v);
            }
        }
    }
    
    // method to remove an edge from the graph
    public void removeEdge(int u, int v) {
        if (u < V && v < V) {
            adjList[u].remove((Integer) v);
        }
    }
    
    // method to get a list of vertices adjacent to a given vertex
    public List<Integer> getAdjacentVertices(int v) {
        List<Integer> adjacentVertices = new ArrayList<>();
        if (v < V) {
            Iterator<Integer> itr = adjList[v].listIterator();
            while (itr.hasNext()) {
                adjacentVertices.add(itr.next());
            }
        }
        return adjacentVertices;
    }
    
    // method to check if there is a directed edge from one vertex to another
    public boolean isConnected(int u, int v) {
        if (u < V && v < V) {
            return adjList[u].contains(v);
        }
        return false;
    }
    
    // method to perform DFS traversal of the graph
    public void DFS(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> itr = adjList[v].listIterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if (!visited[n]) {
                DFS(n, visited);
            }
        }
    }
    
    // method to perform BFS traversal of the graph
    public void BFS(int v, boolean[] visited) {
        LinkedList<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);
        while (queue.size() != 0) {
            v = queue.poll();
            System.out.print(v + " ");
            Iterator<Integer> itr = adjList[v].listIterator();
            while (itr.hasNext()) {
                int n = itr.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    
    // method to find the shortest path between two vertices using BFS
    public List<Integer> shortestPath(int u, int v) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        LinkedList<Integer> queue = new LinkedList<>();
        visited[u] = true;
        queue.add(u);
        while (queue.size() != 0) {
            int w = queue.poll();
            Iterator<Integer> itr = adjList[w].listIterator();
            while (itr.hasNext()) {
                int n = itr.next();
                if (!visited[n]) {
                    visited[n] = true;
                    parent[n] = w;
                    queue.add(n);
                    if (n == v) {
                        List<Integer> path = new ArrayList<>();
                        while (n != -1) {
                            path.add(n);
                            n = parent[n];
                        }
                        Collections.reverse(path);
                        return path;
                    }
                }
            }
        }
        return null;
    }
    
    // main method to test the graph implementation
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        System.out.println("Graph:");
        for (int i = 0; i < g.V; i++) {
            System.out.print(i + ": ");
            for (int j : g.adjList[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("Vertices adjacent to 1: " + g.getAdjacentVertices(1));
        System.out.println("Is there a directed edge from 2 to 3? " + g.isConnected(2, 3));
        boolean[] visited = new boolean[g.V];
        System.out.print("DFS traversal starting from 0: ");
        g.DFS(0, visited);
        System.out.println();
        visited = new boolean[g.V];
        System.out.print("BFS traversal starting from 0: ");
        g.BFS(0, visited);
        System.out.println();
        System.out.println("Shortest path from 0 to 3: " + g.shortestPath(0, 3));
        g.removeVertex(3);
        System.out.println("Graph after removing vertex 3:");
        for (int i = 0; i < g.V; i++) {
            System.out.print(i + ": ");
            for (int j : g.adjList[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        g.removeEdge(1, 4);
        System.out.println("Graph after removing edge from 1 to 4:");
        for (int i = 0; i < g.V; i++) {
            System.out.print(i + ": ");
            for (int j : g.adjList[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}    