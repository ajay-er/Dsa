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
      this.removeEdge(vertex,vertex2)
    }

    delete this.adjacencyList[vertex]

  }
}

let g = new Graph();

g.addVertex('ajay');
g.addVertex('sreerag');
g.addEdge('ajay', 'sreerag');

console.log(g.adjacencyList);

g.removeVertex('ajay');
console.log(g.adjacencyList);
