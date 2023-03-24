package graphcode;

import java.util.ArrayList;
//adjacency list
public class Classroom {

    static class Edge {
        int src;
        int dest;
        int wt;

        // Edge(int src, int dest) {
        // this.src = src;
        // this.dest = dest;
        // }

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2, 2));
        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));
        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));
        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // find the neighbours(destination) of vertex 2
        //it took o(x) for find the neighbours of a 
        for (int i = 0; i < graph[0].size(); i++) {
            Edge e = graph[0].get(i);
            System.out.println(e.dest + ", "+ e.wt);
        }
    }
}
