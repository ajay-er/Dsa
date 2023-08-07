class HashTable {
  constructor(size) {
    this.size = size;
    this.data = new Array(size);
  }

  _hash(key) {
    let hash = 0;
    for (let i = 0; i < key.length; i++) {
      hash = (hash + key.charCodeAt(i) * i) % this.size;
    }
    return hash;
  }

  set(key, value) {
    const index = this._hash(key);
    if (!this.data[index]) {
      this.data[index] = [];
    }
    this.data[index].push([key, value]);
  }

  get(key) {
    const index = this._hash(key);
    const bucket = this.data[index];

    if (bucket) {
      for (const entry of bucket) {
        if (entry[0] === key) {
          return entry[1];
        }
      }
    }
    return undefined;
  }

  keys() {
    const keysArray = [];

    for (const bucket of this.data) {
      if (bucket) {
        for (const entry of bucket) {
          keysArray.push(entry[0]);
        }
      }
    }
    return keysArray;
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

  remove(key) {
    const index = this._hash(key);
    if (this.data[index]) {
      this.data[index] = this.data[index].filter((item) => item[0] !== key);
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
