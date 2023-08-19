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
    node.next = this.head;
    this.head = node;
  }

  delete(data) {
    if (!this.head) {
      console.log('Linked list is empty.');
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
    console.log('Data not found in linked list.');
  }

  findMiddle() {
    if (!this.head) {
      console.log('no data found in linked list.');
      return;
    }

    let first = this.head;
    let second = this.head;
    while (first && second.next) {
      first = first.next;
      second = second.next.next;
    }

    console.log(first.data);
  }
}

const linkedList = new LL();

linkedList.append(10);
linkedList.append(20);
linkedList.prepend(5);
linkedList.append(30);
linkedList.append(40);

console.log('Middle Node:');
linkedList.findMiddle();

linkedList.delete(20);

console.log('After Deletion:');
