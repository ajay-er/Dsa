package rough;

import java.util.*;

public class Graph {
    private int V;
    private ArrayList<Integer>[] adjList;

    Graph(int V){
        this.V = V;
        adjList = new ArrayList[V];
        for (int i = 0; i < adjList.length; i++) {
          adjList[i] = new ArrayList<Integer>();
        }
    }

    void addEdge(int u,int v){
        adjList[u].add(v);
        adjList[v].add(u);
    }


    void removeEdge(int u,int v){
        adjList[u].remove((Integer)v);
        adjList[v].remove((Integer)u);
    }

    void addVertex(){
        V++;
        ArrayList<Integer> newList = new ArrayList<Integer>();
        adjList = Arrays.copyOf(adjList, V);
        adjList[V-1] = newList;
    }

    void removeVertex(int v){
        V--;
        adjList[v] = null;
        for (int i = 0; i < V; i++) {
            if(adjList[i].contains(V)){
                adjList[i].remove((Integer) v);
            }
        }

        adjList = Arrays.copyOf(adjList, V);
    }

    void bfs(int start){
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.print(u + " ");

            for(int v : adjList[u]){
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    void dfsUtil(int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");

        for (int v : adjList[u]) {
            if (!visited[v]) {
                dfsUtil(v, visited);
            }
        }
    }

    void dfs(int start) {
        boolean[] visited = new boolean[V];
        dfsUtil(start, visited);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        
        // Display the adjacency list
        for (int i = 0; i < graph.V; i++) {
            System.out.print(i + ": ");
            for (int j : graph.adjList[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        graph.dfs(0);
        System.out.println();
        graph.bfs(0);
    }
    
}
