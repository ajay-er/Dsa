class Graph {
  constructor() {
    this.adjacencyList = {};
  }

  addVertex(vertex) {
    if (!this.adjacencyList[vertex]) {
      this.adjacencyList[vertex] = [];
    }
  }

  addEdge(v1, v2) {
    if (this.adjacencyList[v1] && this.adjacencyList[v2]) {
      this.adjacencyList[v1].push(v2);
      this.adjacencyList[v2].push(v1);
    }
  }

  removeVertex(vertex) {
    if (!this.adjacencyList[vertex]) throw new Error("oops");
    while (this.adjacencyList[vertex].length) {
      let v = this.adjacencyList[vertex].pop();

      if (this.adjacencyList[v]) {
        this.removeEdge(v, vertex);
      }
    }
    delete this.adjacencyList[vertex];
  }

  removeEdge(v1, v2) {
    this.adjacencyList[v1] = this.adjacencyList[v1].filter((v) => v !== v2);
    this.adjacencyList[v2] = this.adjacencyList[v2].filter((v) => v !== v1);
  }

  dfs(start) {
    const visitedVertices = {};
    let result = [];
    this.#dfs(result, start, visitedVertices);
    return result;
  }

  #dfs(result, node, visitedVertices) {
    if (visitedVertices[node]) {
      return;
    }

    visitedVertices[node] = true;
    result.push(node);

    for (const key of this.adjacencyList[node]) {
      if (!visitedVertices[key]) {
        this.#dfs(result, key, visitedVertices);
      }
    }
  }

  bfs(start) {
    const visitedVertices = {};
    const result = [];
    const queue = [start];

    visitedVertices[start] = true;

    while (queue.length) {
      let currentVertex = queue.shift();
      result.push(currentVertex);

      for (const key of this.adjacencyList[currentVertex]) {
        if (!visitedVertices[key]) {
          visitedVertices[key] = true;
          queue.push(key);
        }
      }
    }
    return result;
  }
}

const graph = new Graph();

// Add vertices
graph.addVertex("A");
graph.addVertex("B");
graph.addVertex("C");
graph.addVertex("D");

// Add edges
graph.addEdge("A", "B");
graph.addEdge("A", "C");
graph.addEdge("B", "D");
graph.addEdge("C", "D");

// Test dfs
console.log(graph.dfs("A")); // Output: ['A', 'B', 'D', 'C']

// Remove vertex
graph.removeVertex("C");

// Test dfs after removing vertex
console.log(graph.dfs("A")); // Output: ['A', 'B', 'D']

// Try removing a nonexistent vertex
try {
  graph.removeVertex("Z");
} catch (error) {
  console.log(error.message); // Output: "oops"
}

// Add a new vertex and test dfs again
graph.addVertex("E");
graph.addEdge("D", "E");
console.log(graph.dfs("A")); // Output: ['A', 'B', 'D', 'E']
