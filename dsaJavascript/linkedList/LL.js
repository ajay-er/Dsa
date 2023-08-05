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

    if (!this.head) {
      this.head = node;
    } else {
      let current = this.head;

      while (current.next) {
        current = current.next;
      }

      current.next = node;
    }
  }

  prepend(data) {
    let node = new Node(data);

    if (!this.head) {
      this.head = node;
    } else {
      node.next = this.head;
      this.head = node;
    }
  }

  delete(data) {
    if (!this.head) {
      throw new Error('No values in Linked List');
    }

    let current = this.head;

    if (this.head.data === data) {
      this.head = this.head.next;
      return;
    }

    while (current.next) {
      if (current.next.data === data) {
        if (current.next.next) {
          current.next = current.next.next;
        } else {
          current.next = null;
        }
        return;
      }

      current = current.next;
    }
  }

  print() {
    if (!this.head) {
      throw new Error('No values in Linked List');
    }

    let current = this.head;

    while (current) {
      console.log(current.data);
      current = current.next;
    }
  }
}

let list = new LinkedList();

list.append(283);
list.append(1);
list.prepend(127);
list.append(123);
list.append(121);

list.prepend(3);
list.delete(127);

list.print();
