package graphcode;

import java.util.*;

public class Graph2 {
    private Map<Integer, Set<Integer>> adjacencyList;

    public Graph2() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashSet<>());
        }
    }

    public void addEdge(int v1, int v2) {
        addVertex(v1);
        addVertex(v2);
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }

    public void removeVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return;
        }

        Set<Integer> neighbors = adjacencyList.get(vertex);
        for (int neighbor : neighbors) {
            adjacencyList.get(neighbor).remove(vertex);
        }

        adjacencyList.remove(vertex);
    }

    public void removeEdge(int v1, int v2) {
        if (!adjacencyList.containsKey(v1) || !adjacencyList.containsKey(v2)) {
            return;
        }

        adjacencyList.get(v1).remove(v2);
        adjacencyList.get(v2).remove(v1);
    }

    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public boolean hasEdge(int v1, int v2) {
        if (!adjacencyList.containsKey(v1) || !adjacencyList.containsKey(v2)) {
            return false;
        }

        return adjacencyList.get(v1).contains(v2) && adjacencyList.get(v2).contains(v1);
    }

    public Set<Integer> getVertices() {
        return adjacencyList.keySet();
    }

    public List<int[]> getEdges() {
        List<int[]> edges = new ArrayList<>();
        Set<int[]> seenEdges = new HashSet<>();

        for (int vertex : adjacencyList.keySet()) {
            for (int neighbor : adjacencyList.get(vertex)) {
                int[] edge = {vertex, neighbor};
                if (!seenEdges.contains(edge)) {
                    edges.add(edge);
                    seenEdges.add(edge);
                }
            }
        }

        return edges;
    }

    public Set<Integer> getNeighbors(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return null;
        }

        return adjacencyList.get(vertex);
    }

    public boolean isConnected() {
        if (adjacencyList.isEmpty()) {
            return true;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(adjacencyList.keySet().iterator().next());

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            visited.add(vertex);

            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }

        return visited.size() == adjacencyList.size();
    }

    public boolean isCyclic() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> ancestors = new HashSet<>();

        for (int vertex : adjacencyList.keySet()) {
            if (isCyclicHelper(vertex, visited, ancestors)) {
                return true;
            }
        }

        return false;
    }

    private boolean isCyclicHelper(int vertex, Set<Integer> visited, Set<Integer> ancestors) {
        visited.add(vertex);
        ancestors.add(vertex);

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                if (isCyclicHelper(neighbor, visited, ancestors)) {
                    return true;
                }
            } else if (
                ancestors.contains(neighbor)) {
                    return true;
                }
            }
        
            ancestors.remove(vertex);
            return false;
        }
        
        public static void main(String[] args) {
            Graph2 graph = new Graph2();
        
            graph.addEdge(1, 2);
            graph.addEdge(2, 3);
            graph.addEdge(3, 1);
        
            System.out.println(graph.isConnected()); // true
            System.out.println(graph.isCyclic()); // true
        
            graph.addEdge(4, 5);
        
            System.out.println(graph.isConnected()); // false
            System.out.println(graph.isCyclic()); // false
        
            graph.addEdge(5, 6);
            graph.addEdge(6, 4);
        
            System.out.println(graph.isConnected()); // true
            System.out.println(graph.isCyclic()); // true
        
            graph.removeVertex(4);
            graph.removeEdge(2, 3);
        
            System.out.println(graph.isConnected()); // true
            System.out.println(graph.isCyclic()); // false
        }
    }        