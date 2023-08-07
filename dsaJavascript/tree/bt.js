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
    const newNode = new Node(data);

    if (this.root === null) {
      this.root = newNode;
    } else {
      this._insertRecursive(this.root, newNode);
    }
  }

  _insertRecursive(node, newNode) {
    if (newNode.data < node.data) {
      if (node.left === null) {
        node.left = newNode;
      } else {
        this._insertRecursive(node.left, newNode);
      }
    } else {
      if (node.right === null) {
        node.right = newNode;
      } else {
        this._insertRecursive(node.right, newNode);
      }
    }
  }

  search(data) {
    return this._searchRecursive(this.root, data);
  }

  _searchRecursive(node, data) {
    if (node === null) {
      return false;
    }

    if (node.data === data) {
      return true;
    } else if (node.data < data) {
      return this._searchRecursive(node.left, data);
    } else {
      return this._searchRecursive(node.right, data);
    }
  }

  inOrderTraversal(node) {
    if (!node) {
      return;
    }
    this.inOrderTraversal(node.left);
    console.log(node.data);
    this.inOrderTraversal(node.right);
  }

  postOrderTraversal(node) {
    if (!node) {
      return;
    }
    this.postOrderTraversal(node.left);
    this.postOrderTraversal(node.right);
    console.log(node.data);
  }

  preOrderTraversal(node) {
    if (!node) {
      return;
    }
    console.log(node.data);
    this.preOrderTraversal(node.left);
    this.preOrderTraversal(node.right);
  }

  delete(data) {
    this.root = this._deleteNode(this.root, data);
  }

  _deleteNode(node, data) {
    if (!node) return null;

    if (data < node.data) {
      node.left = this._deleteNode(node.left, data);
    } else if (data > node.data) {
      node.right = this._deleteNode(node.right, data);
    } else {
      if (!node.left) {
        return node.right;
      }

      if (!node.right) {
        return node.left;
      }
      const inOrderSuccessor = this._findMinNode(node.right);
      node.data = inOrderSuccessor.data;
      node.right = this._deleteNode(node.right, inOrderSuccessor.data);
    }

    return node;
  }

  _findMinNode(node) {
    while (node.left) {
      node = node.left;
    }
    return node;
  }
}

let bt = new BinaryTree();
bt.insert(8);
bt.insert(2);
bt.insert(94);
bt.insert(90);
bt.insert(12);
bt.insert(1);
bt.insert(39);

bt.preOrderTraversal(bt.root);
console.log('..................');
bt.delete(2);
console.log('..................');
bt.preOrderTraversal(bt.root);
