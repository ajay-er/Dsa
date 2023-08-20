class Node {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}
class Bst {
  constructor() {
    this.root = null;
  }

  insert(data) {
    let node = new Node(data);
    if (!this.root) {
      this.root = node;
    } else this.#insertRecursivly(this.root, node);
  }

  #insertRecursivly(root, newNode) {
    if (root.data > newNode.data) {
      if (!root.left) {
        root.left = newNode;
      } else {
        return this.#insertRecursivly(root.left, newNode);
      }
    } else {
      if (!root.right) {
        root.right = newNode;
      } else {
        return this.#insertRecursivly(root.right, newNode);
      }
    }
  }

  search(data) {
    return this.#searchRecursivly(this.root, data);
  }

  #searchRecursivly(node, data) {
    if (!node) {
      return false;
    }

    if (node.data === data) {
      return true;
    } else if (node.data > data) {
      return this.#searchRecursivly(node.left, data);
    } else {
      return this.#searchRecursivly(node.right, data);
    }
  }

  //?traversals
  inOrder() {
    console.log('//');

    this.#inOrderTraversal(this.root);
  }

  #inOrderTraversal(node) {
    if (!node) {
      return;
    }

    this.#inOrderTraversal(node.left);
    console.log(node.data);
    this.#inOrderTraversal(node.right);
  }

  preOrder() {
    console.log('//');

    this.#preOrderTraversal(this.root);
  }

  #preOrderTraversal(node) {
    if (!node) {
      return;
    }

    console.log(node.data);
    this.#preOrderTraversal(node.left);
    this.#preOrderTraversal(node.right);
  }

  postOrder() {
    console.log('//');
    this.#postOrderTraversal(this.root);
  }

  #postOrderTraversal(node) {
    if (!node) {
      return;
    }

    this.#postOrderTraversal(node.left);
    this.#postOrderTraversal(node.right);
    console.log(node.data);
  }

  delete(data) {
    this.root = this.#deleteNode(this.root, data);
  }

  #deleteNode(node, data) {
    if (!node) {
      return node;
    }
    if (node.data < data) {
      node.left = this.#deleteNode(node.left, data);
    } else if (node.data > data) {
      node.right = this.#deleteNode(node.right, data);
    } else {
      if (!node.left) return node.right;
      if (!node.right) return node.left;

      let inOrderSuccessor = this.#findInOrderSuccessor(node.right);
      node.data = inOrderSuccessor.data;

      node.right = this.#deleteNode(node.right, inOrderSuccessor.data);
    }
    return node;
  }

  #findInOrderSuccessor(node) {
    while (node.left) {
      node = node.left;
    }
    return node;
  }
}

let bst = new Bst();

bst.insert(99);
bst.insert(2);
bst.insert(12);
bst.insert(23);

bst.inOrder();
bst.postOrder();
bst.preOrder();
