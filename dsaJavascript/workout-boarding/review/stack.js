class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
  }

  push(data) {
    let node = new Node(data);

    if (!this.head) {
      this.head = node;
      this.tail = node;
    } else {
      let current = this.head;

      while (current.next) {
        current = current.next;
      }
      current.next = node;
      this.tail = node;
    }
  }

  pop() {
    if (!this.head) throw new Error('NO');
    


  }
}

let ll = new LinkedList();

