class Hash {
  constructor(size) {
    this.size = size;
    this.bucket = new Array(size);
  }

  set(key, value) {
    let index = this.#hash(key);
    if (!this.bucket[index]) {
      this.bucket[index] = [];
    }
    this.bucket[index].push([key, value]);
  }

  get(key) {
    let index = this.#hash(key);
    let bucket = this.bucket[index];

    if (bucket) {
      for (const arr of bucket) {
        if (arr[0] === key) {
          return arr[1];
        }
      }
    }
    return undefined;
  }

  display() {
    for (const buckets of this.bucket) {
      if (buckets) {
        for (const entry of buckets) {
          console.log(`${entry[0]}:${entry[1]}`);
        }
      }
    }
  }

  #hash(key) {
    let hash = 0;
    for (let i = 0; i < key.length; i++) {
      hash = (hash + key.charCodeAt(i) * i) % this.size;
    }
    return hash;
  }
}


let hash = new Hash(10);

hash.set('key','value')
hash.set('ke2','value2')
hash.display()