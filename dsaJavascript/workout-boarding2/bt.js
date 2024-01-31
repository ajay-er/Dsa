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
    this.root = this.#insert(this.root, value);
  }

  #insert(root, value) {
    if (root === null) return new TreeNode(value);

    if (value < root.value) {
      root.left = this.#insert(root.left, value);
    } else {
      root.right = this.#insert(root.right, value);
    }

    return root;
  }

  search(value) {
    return this.#search(this.root, value);
  }

  #search(root, value) {
    if (root === null || root.value === value) return root;

    if (value < root.value) {
      return this.#search(root.left, value);
    } else {
      return this.#search(root.right, value);
    }
  }

  #inOrderTraversal(root) {
    if (root !== null) {
      this.#inOrderTraversal(root.left);
      console.log(root.value);
      this.#inOrderTraversal(root.right);
    }
  }

  inOrder() {
    this.#inOrderTraversal(this.root);
  }

  #preOrderTraversal(root) {
    if (root !== null) {
      console.log(root.value);
      this.#preOrderTraversal(root.left);
      this.#preOrderTraversal(root.right);
    }
  }

  preOrder() {
    this.#preOrderTraversal(this.root);
  }

  #postOrderTraversal(root) {
    if (root !== null) {
      this.#postOrderTraversal(root.left);
      this.#postOrderTraversal(root.right);
      console.log(root.value);
    }
  }

  postOrder() {
    this.#postOrderTraversal(this.root);
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

// binaryTree.inOrder()
// binaryTree.preOrder()
binaryTree.postOrder()