class Graph {
  constructor() {
    this.adjacencyList = {};
  }

  addVertex(vertex) {
    if (!this.adjacencyList[vertex]) this.adjacencyList[vertex] = [];
  }

  addEdge(v1, v2) {
    if (this.adjacencyList[v1] && this.adjacencyList[v2])
      this.adjacencyList[v1].push(v2);
    if (this.adjacencyList[v2] && this.adjacencyList[v2])
      this.adjacencyList[v2].push(v1);
  }

  removeEdge(v1, v2) {
    this.adjacencyList[v1] = this.adjacencyList[v1].filter((v) => v !== v2);
    this.adjacencyList[v2] = this.adjacencyList[v2].filter((v) => v !== v1);
  }

  removeVertex(vertex) {
    while (this.adjacencyList[vertex].length) {
      let vertex2 = this.adjacencyList[vertex].pop();
      this.removeEdge(vertex, vertex2);
    }

    delete this.adjacencyList[vertex];
  }

  //using recursive method
  depthFirstRecursive(start) {
    const result = [];
    const visitedVertices = {};
    this.dfs(start, visitedVertices, result);
    return result;
  }

  dfs(vertex, visitedVertices, result) {
    if (visitedVertices[vertex]) return;

    visitedVertices[vertex] = true;
    result.push(vertex);

    for (const neighborVertex of this.adjacencyList[vertex]) {
      if (!visitedVertices[neighborVertex])
        this.dfs(neighborVertex, visitedVertices, result);
    }
  }

  //using iterative method
  depthFirstIterative(start) {
    const stack = [start];
    const result = [];
    const visitedVertices = {};
    let currentVertex;

    visitedVertices[start] = true;
    while (stack.length) {
      currentVertex = stack.pop();
      result.push(currentVertex);

      this.adjacencyList[currentVertex].forEach((neighbor) => {
        if (!visitedVertices[neighbor]) {
          visitedVertices[neighbor] = true;
          stack.push(neighbor);
        }
      });
    }

    return result;
  }

  breadthFirstSearch(start) {
    const queue = [start];
    const result = [];
    const visitedVertices = {};

    let currentVertex;
    visitedVertices[start] = true;

    while (queue.length) {
      currentVertex = queue.shift();
      result.push(currentVertex);

      this.adjacencyList[currentVertex].forEach((neighbor) => {
        if (!visitedVertices[neighbor]) {
          visitedVertices[neighbor] = true;
          queue.push(neighbor);
        }
      });
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

console.log(g.adjacencyList);

console.log(g.breadthFirstSearch('ajay'));
