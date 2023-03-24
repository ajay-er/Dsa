package graphcode;


import java.util.*;

public class Graph3 {
    private ArrayList<Integer>[] adjList;
    private int numVertices;

    public Graph3(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    public void removeEdge(int u, int v) {
        adjList[u].remove(Integer.valueOf(v));
        adjList[v].remove(Integer.valueOf(u));
    }

    public void removeVertex(int v) {
        for (int i = 0; i < numVertices; i++) {
            if (adjList[i].contains(v)) {
                adjList[i].remove(Integer.valueOf(v));
            }
        }
        adjList[v] = new ArrayList<>();
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[numVertices];
        dfsHelper(start, visited);
    }

    private void dfsHelper(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int neighbor : adjList[v]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public List<Integer> getNeighbors(int v) {
        return adjList[v];
    }

    public boolean isConnected() {
        boolean[] visited = new boolean[numVertices];
        dfsHelper(0, visited);
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isAcyclic() {
        boolean[] visited = new boolean[numVertices];
        boolean[] inStack = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                if (isAcyclicHelper(i, visited, inStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAcyclicHelper(int v, boolean[] visited, boolean[] inStack) {
        visited[v] = true;
        inStack[v] = true;
        for (int neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                if (isAcyclicHelper(neighbor, visited, inStack)) {
                    return true;
                }
            } else if (inStack[neighbor]) {
                return true;
            }
        }
        inStack[v] = false;
        return false;
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adjList[i].size(); j++) {
                System.out.print(adjList[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph3 g = new Graph3(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        System.out.println("Graph before removal:");
        g.printGraph();
    
        g.removeEdge(0, 2);
        System.out.println("Graph after removing edge (0, 2):");
        g.printGraph();
    
        g.removeVertex(1);
        System.out.println("Graph after removing vertex 1:");
        g.printGraph();
    
        System.out.println("DFS traversal starting from vertex 0:");
        g.dfs(0);
        System.out.println();
    
        System.out.println("BFS traversal starting from vertex 0:");
        g.bfs(0);
        System.out.println();
    
        System.out.println("Neighbors of vertex 0:");
        System.out.println(g.getNeighbors(0));
    
        System.out.println("Is the graph connected?");
        System.out.println(g.isConnected());
    
        System.out.println("Is the graph acyclic?");
        System.out.println(g.isAcyclic());
    }
}