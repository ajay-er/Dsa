class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
  }

  append(data) {
    let node = new Node(data);

    if (!this.head) this.head = node;
    else {
      let current = this.head;

      while (current.next) {
        current = current.next;
      }

      current.next = node;
    }
  }

  prepend(data) {
    let node = new Node(data);
    node.next = this.head;
    this.head = node;
  }

  delete(data) {
    if (!this.head) throw new Error('oops no ll');

    if (this.head.data === data) {
      this.head = this.head.next;
      return;
    }

    let current = this.head;

    while (current.next) {
      if (current.next.data === data) {
        if (current.next.next) {
          current.next = current.next.next;
        } else {
            current.next = null
        }
        return;
      }

      current = current.next;
    }
  }

  print() {
    if (!this.head) {
      throw new Error('oops LL not found');
    } else {
      let current = this.head;
      while (current) {
        console.log(current.data);
        current = current.next;
      }
    }
  }
}

let myList = new LinkedList();

myList.append(1);
myList.append(2);
myList.append(3);

myList.prepend(0);
myList.prepend(10);

myList.print();
