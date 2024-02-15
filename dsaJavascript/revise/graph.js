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

  removeVertex(vertex) {
    while (this.adjacencyList[vertex].length) {
      let v2 = this.adjacencyList[vertex].pop();
      this.removeEdge(vertex, v2);
    }
    delete this.adjacencyList[vertex];
  }

  removeEdge(v1, v2) {
    if (this.adjacencyList[v1] && this.adjacencyList[v2]) {
      this.adjacencyList[v1] = this.adjacencyList[v1].filter((k) => k !== v2);
      this.adjacencyList[v2] = this.adjacencyList[v2].filter((k) => k !== v1);
    }
  }

  display() {
    for (const key in this.adjacencyList) {
      const neighbors = this.adjacencyList[key].join(', ');
      console.log(`${key} -> ${neighbors}`);
    }
  }

  dfs(start) {
    const result = [];
    const visitedVertices = {};
    this.#dfsRecursive(start, result, visitedVertices);
    return result;
  }

  #dfsRecursive(vertex, result, visitedVertices) {
    if (visitedVertices[vertex]) return;

    visitedVertices[vertex] = true;
    result.push(vertex);

    for (const key of this.adjacencyList[vertex]) {
      if (!visitedVertices[key]) {
        this.#dfsRecursive(key, result, visitedVertices);
      }
    }
  }

  bfs(start) {
    const queue = [start];
    const visitedVertices = {};
    const result = [];

    let currentVertex;
    visitedVertices[start] = true;

    while (queue.length) {
      currentVertex = queue.shift();
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

let g = new Graph();

g.addVertex('ajay');
g.addVertex('sreerag');
g.addVertex('unni');
g.addVertex('kumar');
g.addVertex('ajith');
g.addVertex('sachin');
g.addEdge('unni', 'kumar');
g.addEdge('ajay', 'unni');
g.addEdge('ajay', 'kumar');
g.addEdge('ajay', 'sreerag');
g.addEdge('sachin', 'sreerag');
g.addEdge('ajith', 'sachin');

g.display();
