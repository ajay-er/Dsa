class Node {
  constructor() {
    this.children = {};
    this.isLastWord = false;
  }
}

class Trie {
  constructor() {
    this.root = new Node();
  }

  insert(word) {
    let node = this.root;
    for (const char of word) {
      if (!node.children[char]) {
        node.children[char] = new Node();
      }
      node = node.children[char];
    }
    node.isLastWord = true;
  }

  search(word) {
    let node = this.root;
    for (const char of word) {
      if (!node.children[char]) return false;
      node = node.children[char];
    }
    return node.isLastWord;
  }

  findAllWords(prefix) {
    let words = [];
    const node = this.findNode(prefix);
    if (node) {
      this.findWordsHelper(node, words, prefix);
    }
    return words;
  }

  findNode(prefix) {
    let node = this.root;
    for (const char of prefix) {
      if (!node.children[char]) {
        return null;
      }
      node = node.children[char];
    }
    return node;
  }

  findWordsHelper(node, words, prefix) {
    if (node.isLastWord) words.push(prefix);
    for (const key in node.children) {
      if (node.children.hasOwnProperty(key)) {
        this.findWordsHelper(node.children[key], words, prefix + key);
      }
    }
  }
}


const trie = new Trie();

// Insert some words
trie.insert("apple");
trie.insert("banana");
trie.insert("app");
trie.insert("apples");
trie.insert("orange");

// Test search method
console.log(trie.search("apple")); // true
console.log(trie.search("app")); // true
console.log(trie.search("banana")); // true
console.log(trie.search("orange")); // true
console.log(trie.search("grape")); // false

// Test findAllWords method
console.log(trie.findAllWords("ap")); // ["app", "apple", "apples"]
console.log(trie.findAllWords("ban")); // ["banana"]
console.log(trie.findAllWords("or")); // ["orange"]
console.log(trie.findAllWords("gr")); // []

// Test with empty string
console.log(trie.search("")); // false
console.log(trie.findAllWords("")); // []

// Test with prefix not in the trie
console.log(trie.findAllWords("kiwi")); // []

// Inserting empty string
trie.insert("");
console.log(trie.search("")); // true
console.log(trie.findAllWords("")); // [""]

// Test with words having common prefix
trie.insert("appetizer");
console.log(trie.search("appetizer")); // true
console.log(trie.findAllWords("app")); // ["app", "apple", "apples", "appetizer"]
