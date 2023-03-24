package implementation;

import java.util.*;

public class Graph {
    private ArrayList<Integer> adList[];
    private int numV;

    Graph(int numV) {
        this.numV = numV;
        adList = new ArrayList[numV];

        for (int i = 0; i < numV; i++) {
            adList[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v) {
        adList[u].add(v);
        adList[v].add(u);
    }

    void removeEdge(int u, int v) {
        adList[u].remove(Integer.valueOf(v));
        adList[v].remove(Integer.valueOf(u));
    }

    void removeVertex(int v) {
        for (int i = 0; i < numV; i++) {
            adList[i].remove(Integer.valueOf(v));
        }

        adList[v] = new ArrayList<Integer>();
    }

    ArrayList<Integer> getNeighbours(int v) {
        return adList[v];
    }

    void dfs(int start) {
        boolean[] visited = new boolean[numV];
        dfsHelper(visited, start);
    }

    private void dfsHelper(boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int neighbor : adList[v]) {
            if (!visited[neighbor]) {
                dfsHelper(visited, neighbor);
            }
        }
    }

    void bfs(int start) {
        boolean[] visited = new boolean[numV];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {

            int v = queue.poll();
            System.out.print(v + " ");
            for (int neighbor : adList[v]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }

        }
    }


    void print(){
        for (int i = 0; i < numV; i++) {
            System.out.print(i+": ");
            for (int j = 0; j < adList[i].size();j++){
                System.out.print(adList[i].get(j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.print();

        System.out.println();

        g.bfs(0);

        System.out.println();

        g.dfs(0);
    }
}
