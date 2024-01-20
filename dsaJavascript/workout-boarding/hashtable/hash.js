class HashTable {
  constructor(size) {
    this.size = size;
    this.data = new Array(size);
  }

  #hash(key) {
    let hash = 0;
    for (let i = 0; i < key.length; i++) {
      hash += key.charCodeAt(i);
    }
    return hash % this.size;
  }

  set(key, value) {
    const index = this.#hash(key);
    if (!this.data[index]) {
      this.data[index] = [];
    }
    this.data[index].push([key, value]);
  }

  get(key) {
    const index = this.#hash(key);
    while (this.data[index]) {
      for (const item of this.data[index]) {
        if (item[0] === key) {
          return item[1];
        }
      }
    }
    return undefined;
  }

  remove(key) {
    const index = this.#hash(key);
    if (this.data[index]) {
      this.data[index] = this.data[index].filter((item) => item[0] !== key);
    }
  }

  display() {
    for (const bucket of this.data) {
      if (bucket) {
        for (const entry of bucket) {
          console.log(`${entry[0]}:${entry[1]}`);
        }
      }
    }
  }
}

const hash = new HashTable(10);

hash.set(1, 'ajay');
hash.set(2, 'vijay');
hash.set(3, 'john');

hash.display();
hash.remove(2);
console.log('after remove');
hash.display();
