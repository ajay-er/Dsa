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
    let index = this._hash(key);
    if (!this.data[index]) this.data[index] = [];
    this.data[index].push([key, value]);
  }

  get(key) {
    let index = this._hash(key);
    let bucket = this.data[index];
    if (bucket) {
      for (const entry of bucket) {
        if (entry[0] === key) {
          return entry[1];
        }
      }
    }
    return undefined;
  }

  display() {
    for (const buckets of this.data) {
      if (buckets) {
        for (const entry of buckets) {
          console.log(`${entry[0]}:${entry[1]}`);
        }
      }
    }
  }
}


let hash = new HashTable(10);
hash.set(1,'ajay');
hash.set(2,'vijay');
hash.set(3,'prnav');

hash.display()