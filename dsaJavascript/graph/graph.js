class Graph{
    constructor() {
        this.vertices = new Map()
    }

    addVertex(vertex){
        if(!this.vertices.has(vertex)){
            this.vertices.set(vertex,[])
        }
    }

    addEdges(vertex1,vertex2){
        if(this.vertices.has(vertex1) && this.vertices.has(vertex2)){
            this.vertices.get(vertex1).push(vertex2);
            this.vertices.get(vertex2).push(vertex1);
        }
    }

    getNeighbors(vertex){
        if(this.vertices.has(vertex)){
            return this.vertices.get(vertex)
        }
        return []
    }
}