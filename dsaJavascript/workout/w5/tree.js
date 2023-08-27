class Node {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

class Tree {
  constructor() {
    this.root = null;
  }

  insert(data) {
    let node = new Node(data);
    if (!this.root) {
      this.root = node;
    } else {
      this.#insertRecursively(node, this.root);
    }
  }

  #insertRecursively(newNode, node) {
    if (!node) {
      return newNode;
    }
    if (newNode.data < node.data) {
      node.left = this.#insertRecursively(newNode, node.left);
    } else {
      node.right = this.#insertRecursively(newNode, node.right);
    }
    return node;
  }

  search(data) {
    return this.#searchRecursively(data, this.root);
  }

  #searchRecursively(data, node) {
    if (!node) {
      return false;
    }

    if (node.data === data) {
      return true;
    } else if (node.data > data) {
      return this.#searchRecursively(data, node.left);
    } else if (node.data < data) {
      return this.#searchRecursively(data, node.right);
    }
  }
}
