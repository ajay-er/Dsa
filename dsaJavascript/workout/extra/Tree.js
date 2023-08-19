class Node {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

class BinaryTree {
  constructor() {
    this.root = null;
  }

  insert(data) {
    let node = new Node(data);
    if (!this.root) {
      this.root = node;
    } else {
      this.#insertRecursive(this.root, node);
    }
  }

  #insertRecursive(root, newNode) {
    if (root.data < newNode.data) {
      if (!root.left) {
        root.left = newNode;
      } else {
        this.#insertRecursive(root.left, newNode);
      }
    } else {
      if (!root.right) {
        root.right = newNode;
      } else {
        this.#insertRecursive(root.right, newNode);
      }
    }
  }

  search(data) {
    return this.#searchRecursive(this.root, data);
  }

  #searchRecursive(node, data) {
    if (!node) {
      return false;
    }

    if (node.data === data) {
      return true;
    } else if (node.data > data) {
      return this.#searchRecursive(node.left, data);
    } else {
      return this.#searchRecursive(node.right, data);
    }
  }

  //* Traversals
  preOrder() {
    console.log('preorder:');
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
    console.log('postorder:');
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

  inOrder() {
    console.log('inorder:');
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

  levelOrder() {
    console.log('levelOrder:');
    this.#levelOrderTraversal(this.root);
  }

  #levelOrderTraversal(node) {
    if (!node) {
      return;
    }
    let queue = [];
    queue.push(node);

    while (queue.length > 0) {
      const current = queue.shift();
      console.log(current.data);
      if (current.left) {
        queue.push(current.left);
      }
      if (current.right) {
        queue.push(current.right);
      }
    }
  }

  delete(data) {
    this.root = this.#deleteNode(this.root, data);
  }

  #deleteNode(node, data) {
    if (!node) return null;

    if (node.data < data) {
      node.left = this.#deleteNode(node.left, data);
    } else if (node.data > data) {
      node.right = this.#deleteNode(node.right, data);
    } else {
      if (!node.left) return node.right;
      if (!node.right) return node.left;

      const successor = this.#findInOrderSuccessor(node.right);
      node.data = successor.data;
      node.right = this.#deleteNode(node.right, successor.data);
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

let bst = new BinaryTree();

bst.insert(2);
bst.insert(88);
bst.insert(23);
bst.insert(92);
bst.insert(12);

bst.levelOrder();

bst.preOrder();
bst.postOrder();
bst.inOrder();
