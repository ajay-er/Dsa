class TrieNode {
  constructor() {
    this.children = {};
    this.isEndOfWord = false;
  }
}

class Trie {
  constructor() {
    this.root = new TrieNode();
  }

  insert(word) {
    let node = this.root;
    for (const char of word) {
      if (!node.children[char]) {
        node.children[char] = new TrieNode();
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

  findAllWordsWithPrefix(prefix) {
    let node = this.root;
    for (const char of prefix) {
      if (!node.children[char]) {
        console.log('no words found');
        return [];
      }
      node = node.children[char];
    }
    let words = [];

    this.#collectWords(node, prefix, words);

    return words;
  }

  #collectWords(node, currentWord, words) {
    if (node.isEndOfWord) {
      words.push(currentWord);
    }

    for (const char in node.children) {
      this.#collectWords(node.children[char], currentWord + char, words);
    }
  }
}

const t = new Trie();

t.insert('Ajay');
t.insert('Ajmal');
t.insert('vijay');
t.insert('vinay');
console.log(t.findAllWordsWithPrefix('v'));
