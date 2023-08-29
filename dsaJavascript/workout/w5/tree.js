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

  inorder() {
    this.#inorderTraversal(this.root);
  }

  #inorderTraversal(node) {
    if (!node) {
      return;
    }

    this.#inorderTraversal(node.left);
    console.log(node.data);
    this.#inorderTraversal(node.right);
  }

  preorder() {
    this.#preorderTraversal(this.root);
  }

  #preorderTraversal(node) {
    if (!node) {
      return;
    }

    console.log(node.data);
    this.#preorderTraversal(node.left);
    this.#preorderTraversal(node.right);
  }

  postorder() {
    this.#postorderTraversal(this.root);
  }

  #postorderTraversal(node) {
    this.#postorderTraversal(node.left);
    this.#postorderTraversal(node.right);
    console.log(node.data);
  }
}

let t = new Tree();

t.insert(3);
t.insert(9);
t.insert(7);
t.insert(2);
t.insert(11);
t.inorder();
