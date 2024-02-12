class Graph {
  constructor() {
    this.adjecencyList = {};
  }

  addVertex(vertex) {
    if (!this.adjecencyList[vertex]) this.adjecencyList[vertex] = [];
  }

  addEdges(v1, v2) {
    if (this.adjecencyList[v1] && this.adjecencyList[v2]) {
      this.adjecencyList[v1].push(v2);
      this.adjecencyList[v2].push(v1);
    }
  }

  removeEdge(v1, v2) {
    this.adjecencyList[v1] = this.adjecencyList[v1].filter((v) => v !== v2);
    this.adjecencyList[v2] = this.adjecencyList[v2].filter((v) => v !== v1);
  }

  removeVertex(vertex) {
    while(this.adjecencyList[vertex].length) {
        let vertex2 = this.adjecencyList[vertex].pop()
        this.removeEdge(vertex,vertex2)
    }
  }

  bfs(start) {
    let result = []
    let visitedVertices = {}
    this.bfsRecursion(start,visitedVertices,result)
    return result;
  }

  bfsRecursion(vertex,visitedVertices,result) {
    if (visitedVertices[vertex]) return 
    visitedVertices[vertex] = true
    result.push(vertex)

    

  }
}
