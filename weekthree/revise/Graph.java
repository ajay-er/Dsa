    package revise;

    import java.util.*;

    public class Graph {
        private ArrayList<Integer> adjList[];
        private int numV;

        Graph(int numV){
            this.numV = numV;
            this.adjList = new ArrayList[numV];

            for (int i = 0; i < numV; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        void addEdge(int u,int v){
            adjList[u].add(v);
            adjList[v].add(u);
        }

        void removeEdge(int u, int v){
            adjList[u].remove(Integer.valueOf(v));
            adjList[v].remove(Integer.valueOf(u));
        }

        void removeVertex(int v){
            for (int i = 0; i < numV; i++) {
                adjList[i].remove(Integer.valueOf(v));
            }
            adjList[v] = new ArrayList<Integer>();
        }


        ArrayList<Integer> getNeighbors(int v){
            return adjList[v];
        }

        void dfs(int start){
            boolean[] visited = new boolean[numV];
            dfsHelper(start,visited);
        }

        private void dfsHelper(int v, boolean[] visited) {
            visited[v] = true;
            System.out.print(v + " ");
            for (int  neighbor : adjList[v]) {
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
                System.out.print(v + " ");
                for (int neighbor : adjList[v]) {
                    if(!visited[neighbor]){
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }

        public static void main(String[] args) {
            Graph g = new Graph(5);
            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 3);
            g.addEdge(2, 3);
            g.addEdge(3, 4);

            // System.out.println(g.getNeighbors(0));
            // g.dfs(0);
            g.dfs(3);
        }
    }
