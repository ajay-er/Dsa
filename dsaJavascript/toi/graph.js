class Graph {
  constructor() {
    this.adjacencyList = {};
  }

  addVertex(vertex) {
    if (!this.adjacencyList[vertex]) this.adjacencyList[vertex] = [];
  }

  addEdge(v1, v2) {
    if (this.adjacencyList[v1] && this.adjacencyList[v2]) {
      this.adjacencyList[v1].push(v2);
      this.adjacencyList[v2].push(v1);
    }
  }

  removeEdge(v1, v2) {
    this.adjacencyList[v1] = this.adjacencyList[v1].filter(
      (item) => item !== v2
    );
    this.adjacencyList[v2] = this.adjacencyList[v2].filter(
      (item) => item !== v1
    );
  }

  removeVertex(vertex) {
    while (this.adjacencyList[vertex].length) {
      let v = this.adjacencyList[vertex].pop();
      this.removeEdge(vertex, v);
    }
    delete this.adjacencyList[vertex];
  }

  dfs(start) {
    let result = [];
    const visitedVertices = {};
    this.#dfsR(result, visitedVertices, start);
    return result;
  }

  #dfsR(result, visitedVertices, start) {
    if (visitedVertices[start]) return;

    visitedVertices[start] = true;
    result.push(start);

    for (const key of this.adjacencyList[start]) {
      if (!visitedVertices[key]) {
        this.#dfsR(result, visitedVertices, key);
      }
    }
  }

  bfs(start) {
    let queue = [start];
    const visitedVertices = {};
    const result = [];

    visitedVertices[start] = true;

    while (queue.length) {
      let currentVertex = queue.shift();
      result.push(currentVertex);

      for (const edge of this.adjacencyList[currentVertex]) {
        if (!visitedVertices[edge]) {
          visitedVertices[edge] = true;
          queue.push(edge);
        }
      }
    }
    return result;
  }
}

// Create a new instance of the Graph
const socialNetwork = new Graph();

// Add users as vertices
socialNetwork.addVertex("Alice");
socialNetwork.addVertex("Bob");
socialNetwork.addVertex("Charlie");
socialNetwork.addVertex("David");
socialNetwork.addVertex("Eve");

// Add friendships as edges
socialNetwork.addEdge("Alice", "Bob");
socialNetwork.addEdge("Alice", "Charlie");
socialNetwork.addEdge("Bob", "Charlie");
socialNetwork.addEdge("David", "Eve");

// Test removing a friendship
socialNetwork.removeEdge("Alice", "Charlie");
console.log(socialNetwork.adjacencyList["Alice"]); // Should print ["Bob"]

// Test removing a user
socialNetwork.removeVertex("David");
console.log(socialNetwork.adjacencyList); // David's connections should be removed
