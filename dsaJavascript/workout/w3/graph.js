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
      let current = this.adjacentcyList[vertex].pop();
      this.removeEdge(vertex, current);
    }
    delete this.adjacentcyList[vertex]
  }
}
