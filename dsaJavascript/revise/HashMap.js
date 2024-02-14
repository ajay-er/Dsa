class Hash {
  constructor(size) {
    this.size = size;
    this.items = new Array(size);
  }

  #hash(key) {
    let hash = 0;
    for (let i = 0; i < key.length; i++) {
      hash += key.charCodeAt(i) * i;
    }
    return hash % this.size;
  }

  set(key, value) {
    const index = this.#hash(key);
    if (!this.items[index]) {
      this.items[index] = [];
    }
    this.items[index].push([key, value]);
  }

  get(key) {
    const index = this.#hash(key);
    if (!this.items[index]) return 'oops';
    for (const value of this.items[index]) {
      if (value[0] === key) {
        return value[1];
      }
    }
    return 'not found';
  }

  remove(key) {
    const index = this.#hash(key);
    const bucket = this.items[index];
    if (!bucket) return 'oops';
    this.items[index] = bucket.filter((item) => item[0] !== key);
  }

  display() {
    for (const bucket of this.items) {
      if (bucket) {
        for (const entry of bucket) {
          console.log(`${entry[0]}:${entry[1]}`);
        }
      }
    }
  }

}

const ht = new Hash(10);

ht.set('name', 'John');
ht.set('age', 25);
ht.set('place', 25);
ht.set('wow', 25);
ht.set('super', 25);

ht.remove('age')
ht.display()