class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class LL {
  constructor() {
    this.head = null;
  }

  prepend(data) {
    let newNode = new Node(data);

    if (!this.head) {
      this.head = newNode;
      return;
    }

    newNode.next = this.head;
    this.head = newNode;
  }

  append(data) {
    let newNode = new Node(data);

    if (!this.head) {
      this.head = newNode;
    } else {
      let current = this.head;
      while (current.next) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  delete(data) {
    if (!this.head) {
      console.log('No linked list avaliable');
      return;
    }

    if (this.head.data === data) {
      this.head = this.head.next;
      return;
    }

    let current = this.head;

    while (current.next) {
      if (current.next.data === data) {
        current.next = current.next.next;
        return;
      }
      current = current.next;
    }
  }

  print() {
    let current = this.head;
    while (current) {
      console.log(current.data);
      current = current.next;
    }
  }
}

let l = new LL();

l.append(23);
l.append(2);
l.append(1);
l.append(13);
l.append(99);
l.delete(23);
l.print();
