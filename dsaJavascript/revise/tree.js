class Node {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

class Tree {
  constructor() {
    this.root = null;
  }

  insert(value) {
    const newNode = new Node(value);
    if (this.root === null) {
      this.root = newNode;
    } else {
      this.#insertRecurse(this.root, newNode);
    }
  }

  #insertRecurse(node, newNode) {
    if (newNode.value < node.value) {
      if (node.left === null) node.left = newNode;
      else this.#insertRecurse(node.left, newNode);
    } else {
      if (node.right === null) node.right = newNode;
      else this.#insertRecurse(node.right, newNode);
    }
  }

  search(value) {
    return this.#searchRecurse(this.root, value);
  }

  #searchRecurse(node, value) {
    if (!node) return false;

    if (node.value === value) return true;

    if (value < node.value) {
      return this.#searchRecurse(node.left, value);
    } else {
      return this.#searchRecurse(node.right, value);
    }
  }

  inOrder() {
    this.#inorderTraversal(this.root);
  }

  #inorderTraversal(node) {
    if (!node) return;
    this.#inorderTraversal(node.left);
    console.log(node.value);
    this.#inorderTraversal(node.right);
  }

  preOrder() {
    this.#preOrderTraversal(this.root);
  }

  #preOrderTraversal(node) {
    if (!node) return;
    console.log(node.value);
    this.#preOrderTraversal(node.left);
    this.#preOrderTraversal(node.right);
  }

  postOrder() {
    this.#postOrderTraversal(this.root);
  }

  #postOrderTraversal(node) {
    if (!node) return;
    this.#postOrderTraversal(node.left);
    this.#postOrderTraversal(node.right);
    console.log(node.value);
  }

  levelOrder() {
    this.#levelOrderTraversal(this.root);
  }

  #levelOrderTraversal(node) {
    if (!node) return;

    let queue = [];
    queue.push(node);
    while (queue.length) {
      let current = queue.shift();
      console.log(current.value);
      if (current.left) {
        queue.push(current.left);
      }

      if (current.right) {
        queue.push(current.right);
      }
    }
  }

  delete(value) {
    this.root = this.#deleteNode(this.root, value);
  }

  #deleteNode(node, value) {
    if (!node) return node;

    if (node.value > value) {
      node.left = this.#deleteNode(node.left, value);
    } else if (node.value < value) {
      node.right = this.#deleteNode(node.right, value);
    } else {
      if (!node.left) return node.right;
      if (!node.right) return node.left;

      const inOrderSuccessor = this.#findMinNode(node.right);
      node.value = inOrderSuccessor.value;
      node.right = this.#deleteNode(node.right, node.value);
    }
    return node;
  }

  #findMinNode(node) {
    while (node.left) {
      node = node.left;
    }
    return node;
  }

  isBST() {
    return this.#BSTChecker(this.root);
  }

  #BSTChecker(
    node,
    min = Number.MIN_SAFE_INTEGER,
    max = Number.MAX_SAFE_INTEGER
  ) {
    if (!node) return true;

    if (node.value <= min || node.value >= max) return false;

    return (
      this.#BSTChecker(node.left, min, node.value) &&
      this.#BSTChecker(node.right, node.value, max)
    );
  }
}

let bt = new Tree();
bt.insert(8);
bt.insert(2);
bt.insert(94);
bt.insert(90);
bt.insert(12);
bt.insert(1);
bt.insert(39);

bt.levelOrder();
console.log(bt.isBST());
