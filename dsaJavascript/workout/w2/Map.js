class Map {
  constructor(size) {
    this.size = size;
    this.bucket = new Array(size);
  }

  #hash(key) {
    let hash = 0;
    for (let i = 0; i < key.length; i++) {
      hash = (hash + key.charCodeAt(i) * i) % this.size;
    }

    return hash;
  }

  set(key, value) {
    let index = this.#hash(key);

    if (!this.bucket[index]) this.bucket[index] = [];

    this.bucket[key].push([key, value]);
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
}
