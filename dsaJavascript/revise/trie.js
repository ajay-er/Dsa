class Node {
  constructor() {
    this.children = {};
    this.isEndOfWord = false;
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
    node.isEndOfWord = true;
  }

  search(word) {
    let node = this.root;

    for (const char of word) {
      if (!node.children[char]) return false;
      node = node.children[char];
    }
    return node.isEndOfWord;
  }

  startsWith(word) {
    let node = this.root;
    for (const char of word) {
      if (!node.children[char]) return false;
      node = node.children[char];
    }
    return true;
  }

  findWordWithPrefix(prefix) {
    let words = [];
    let node = this.root;
    for (const char of prefix) {
      if (!node.children[char]) return words;
      node = node.children[char];
    }
    this.#findAllWords(node, words, prefix);
    return words;
  }

  #findAllWords(node, words, word) {
    if (node.isEndOfWord) {
      words.push(word);
    }

    for (const key in node.children) {
      this.#findAllWords(node.children[key], words, word + key);
    }
  }
}

const t = new Trie();

t.insert('Ajay');
t.insert('Ajmal');
t.insert('aju');
t.insert('apple');
t.insert('application');
t.insert('app');
t.insert('appfrond');

console.log(t.findWordWithPrefix('app'));
