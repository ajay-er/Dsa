class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

class BinaryTree {
  constructor() {
    this.root = null;
  }

  insert(value) {
    this.root = this.#insertBt(value, this.root);
  }

  #insertBt(value, node) {
    if (!node) {
      return new TreeNode(value);
    }

    if (value < node.value) {
      node.left = this.#insertBt(value, node.left);
    } else {
      node.right = this.#insertBt(value, node.right);
    }
    return node;
  }

  search(value) {
    return this.#searchNode(value, this.root);
  }

  #searchNode(value, node) {
    if (!node || node.value === value) return node;

    if (value < node.value) {
      return this.#searchNode(value, node.left);
    } else {
      return this.#searchNode(value, node.right);
    }
  }

  #inOrderTraversal(root) {
    if (root) {
      this.#inOrderTraversal(root.left);
      console.log(root.value);
      this.#inOrderTraversal(root.right);
    }
  }

  inOrder() {
    this.#inOrderTraversal(this.root);
  }
}



const binaryTree = new BinaryTree();
binaryTree.insert(5);
binaryTree.insert(3);
binaryTree.insert(7);
binaryTree.insert(2);
binaryTree.insert(4);
binaryTree.insert(6);
binaryTree.insert(8);
binaryTree.inOrder()
