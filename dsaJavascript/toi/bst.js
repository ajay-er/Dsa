class Node {
  constructor(val) {
    this.left = null;
    this.right = null;
    this.val = val;
  }
}

class Bst {
  constructor() {
    this.root = null;
  }

  insert(val) {
    this.root = this._insert(val, this.root);
  }

  _insert(val, node) {
    if (!node) {
      return new Node(val);
    }

    if (node.val > val) {
      node.left = this._insert(val, node.left);
    } else {
      node.right = this._insert(val, node.right);
    }
    return node;
  }

  search(val) {
    return this._search(val, this.root);
  }

  _search(val, node) {
    if (!node) {
      return false;
    }

    if (node.val === val) return true;

    if (node.val < val) {
      return this._search(val, node.right);
    } else {
      return this._search(val, node.left);
    }
  }

  levelOrder() {
    this._levelOrder(this.root);
  }

  _levelOrder(node) {
    if (!node) return;

    const queue = [];
    queue.push(node);
    while (queue.length) {
      let current = queue.shift();
      if (current.left) {
        queue.push(current.left);
      }
      if (current.right) {
        queue.push(current.right);
      }
      console.log(current.val);
    }
  }

  delete(val) {
    this.root = this._delete(this.root, val);
  }

  _delete(node, val) {
    if (!node) return null;

    if (node.val < val) {
      node.right = this._delete(node.right, val);
    } else if (node.val > val) {
      node.left = this._delete(node.left, val);
    } else {
      if (!node.left) {
        return node.right;
      }

      if (!node.right) {
        return node.left;
      }

      let inOrderSuccessor = this.findinOrderSuccess(node.right);
      node.val = inOrderSuccessor.val;
      node.right = this._delete(node.right, inOrderSuccessor.val);
    }
    return node;
  }

  findinOrderSuccess(node) {
    while (node.left) {
      node = node.left;
    }
    return node;
  }
}

const bst = new Bst();

bst.insert(10);
bst.insert(5);
bst.insert(15);
bst.insert(3);
bst.insert(7);
bst.insert(12);
bst.insert(20);

// console.log(bst.root);

// console.log(bst.search(1));

bst.levelOrder();
console.log("-----");
bst.delete(20);
bst.levelOrder();
