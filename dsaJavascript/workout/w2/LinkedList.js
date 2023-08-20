class Node {
  constructor(data) {
    this.next = null;
    this.data = data;
  }
}
class LL {
  constructor() {
    this.head = null;
  }

  append(value) {
    let node = new Node(value);

    if (!this.head) {
      this.head = node;
      return;
    }

    let current = this.head;

    while (current.next) {
      current = current.next;
    }

    current.next = node;
  }

  prepend(value) {
    let node = new Node(value);

    if (!this.head) {
      this.head = node;
      return;
    }

    node.next = this.head;
    this.head = node;
  }

  findTheMiddle() {
    if (!this.head) {
      console.log('No head found');
      return;
    }

    let first = this.head;
    let second = this.head;
    while (first && second.next) {
      first = first.next;
      second = second.next.next;
    }

    return first.data;
  }
}

let l = new LL();

l.append(239);
l.append(2);
l.append(9);
l.append(4);

console.log(l.head);
