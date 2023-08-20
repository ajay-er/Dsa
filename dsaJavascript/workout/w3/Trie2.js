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

  findWordsWithPrefix(prefix) {
    let node = this.root;

    for (const char of prefix) {
      if (!node.children[char]) return [];
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

let trie = new Trie();

trie.insert('Ajay');
trie.insert('Ajmal');
trie.insert('Aju')
trie.insert('Ajal')


console.log(trie.findWordsWithPrefix('Aj'));
