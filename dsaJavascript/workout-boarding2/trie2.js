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
  
    searchWithPrefix(word) {
      let words = [];
      let prefixNode = this.#findPrefix(word);
      if (prefixNode) this.#searchWords(prefixNode, word, words);
      return words;
    }
  
    #findPrefix(word) {
      let node = this.root;
      for (const char of word) {
        if (!node.children[char]) return null;
        node = node.children[char];
      }
      return node;
    }
  
    #searchWords(node, prefix, result) {
      if (node.isEndOfWord) {
        result.push(prefix);
      }
  
      for (const char in node.children) {
        this.#searchWords(node.children[char], prefix + char, result);
      }
    }
  }
  