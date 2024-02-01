class TrieNode {
  constructor() {
    this.children = {};
    this.endOfWord = false;
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
    node.endOfWord = true;
  }

  search(word) {
    let node = this.root;

    for (const char of word) {
      if (!node.children[char]) {
        return false;
      }

      node = node.children[char];
    }
    return node.endOfWord;
  }

  searchWithPrefix(word) {
    let node = this.root;
    let result = [];
    for (const char of word) {
      if (!node.children[char]) return result;
      node = node.children[char];
    }
    if (node) this.#collectWords(node, word, result);
    return result;
  }

  #collectWords(node, word, result) {
    if (node.endOfWord) {
      result.push(word);
    }

    for (const char in node.children) {
      this.#collectWords(node.children[char], word + char, result);
    }
  }
}


const t = new Trie();

t.insert('Ajay');
t.insert('Ajmal');
t.insert('aju');
t.insert('apple');
t.insert('applejam');
t.insert('applewar');

console.log(t.searchWithPrefix('Aj'));
