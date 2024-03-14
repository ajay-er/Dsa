class Map {
  constructor(size) {
    this.size;
    this.bucket = new Array(size);
  }

  #hash(key) {
    let hash = 0;
    for (let i = 0; i < key.length; i++) {
      hash += key.charCodeAt(i) * i;
    }
    return hash % this.size;
  }

  set(key, val) {
    let index = this.#hash(key);

    let position = this.bucket[index];

    if (!position) {
      position = [];
    }
    position.push([key, val]);
  }

  get(key) {
    let index = this.#hash(key);

    if (!this.bucket[index]) return null;

    let result = this.bucket[index].find((item) => item[0] === key);
    return result ? result[1] : null;
  }
}
