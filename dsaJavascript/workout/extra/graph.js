class Graph {
  constructor() {
    this.adjacentcyList = {};
  }

  addVertex(vertex) {
    if (!this.adjacentcyList[vertex]) this.adjacentcyList[vertex] = [];
  }

  addEdge(v1, v2) {
    if (this.adjacentcyList[v1] && this.adjacentcyList[v2]) {
      this.adjacentcyList[v1].push(v2);
      this.adjacentcyList[v2].push(v1);
    }
  }

  removeEdge(v1, v2) {
    this.adjacentcyList[v1] = this.adjacentcyList[v1].filter((v) => v !== v2);
    this.adjacentcyList[v2] = this.adjacentcyList[v2].filter((v) => v !== v1);
  }

  removeVertex(vertex) {
    while (this.adjacentcyList[vertex].length) {
      let v2 = this.adjacentcyList[vertex].pop();
      this.removeEdge(vertex, v2);
    }
    delete this.adjacentcyList[vertex];
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
g.removeVertex('ajith');

console.log(g.adjacentcyList);
