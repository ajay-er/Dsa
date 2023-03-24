package reviewcode;

import java.util.*;

public class Graph{
    ArrayList<Integer>[] adjlist;
    int numV;

    Graph(int numV){
        this.numV = numV;
        this.adjlist = new ArrayList[numV];
        for (int i = 0; i < numV; i++) {
            adjlist[i] = new ArrayList<>();
        }
    }

    void addEdge(int u,int v){
        adjlist[u].add(v);
        adjlist[v].add(u);
    }

    void removeEdge(int u, int v){
        adjlist[u].remove(Integer.valueOf(v));
        adjlist[v].remove(Integer.valueOf(u));
    }

    void removeVertex(int v){
        for (int i = 0; i < adjlist.length; i++) {
            adjlist[i].remove(Integer.valueOf(v));
        }

        adjlist[v] = new ArrayList<Integer>();
    }

    ArrayList<Integer> getneighbours(int v){
        return adjlist[v];
    }

    void dfs(int start){
        boolean[] visited = new boolean[numV];
        dfsHelper(start,visited);

    }

    private void dfsHelper(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v+" ");

        for (int neighbor: adjlist[v]) {
            if(!visited[neighbor]){
                dfsHelper(neighbor, visited);
            }
        }
    }


    void bfs(int start){
        boolean[] visited = new boolean[numV];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()){
            int v = queue.poll();
            System.out.print(v+" ");

            for (int neighbor : adjlist[v]) {
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }

        }
    }


    void dfs2(int start){
        boolean[] visited = new boolean[numV];
        dfsHelper2(start,visited);
    }

    private void dfsHelper2(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v+" ");

        for (int neighbour : adjlist[v]) {
            if(!visited[neighbour]){
                dfsHelper2(neighbour, visited);
            }
        }
    }


    void bfs2(int start){
        boolean[] visited = new boolean[numV];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            int v = q.poll();
            System.out.print(v+" ");

            for (int neighbor : adjlist[v]) {
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }


    void dfs3(int start){
        boolean[] vis = new boolean[numV];
        dfs3(start,vis);
    }

    private void dfs3(int v, boolean[] vis) {
        vis[v] = true;
        System.out.print(v+" ");

        for (int neighbor: adjlist[v]) {
            if(!vis[neighbor]){
                dfs3(neighbor,vis);
            }
        }
    }


    void bfs3(int start){
        boolean[] vis = new boolean[numV];

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        vis[start]= true;

        while(!q.isEmpty()){
            int v = q.poll();
            System.out.print(v+" ");

            for (int neighbor : adjlist[v]) {
                if(!vis[neighbor]){
                    vis[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }

    }

}