class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class LL {
  constructor() {
    this.head = null;
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

  prepend(data) {
    let newNode = new Node(data);
    if (!this.head) {
      this.head = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
  }

  delete(data) {
    if (!this.head) {
      console.log('List is empty. Unable to delete data.');
      return;
    }

    if (this.head.value === data) {
      this.head = this.head.next;
      return;
    }

    let current = this.head;
    while (current.next) {
      if (current.next.value === data) {
        current.next = current.next.next;
        return;
      }
      current = current.next;
    }
    console.log(`Value:${data} not in the list`);
  }

  print() {
    if (!this.head) {
      console.log('No values found!');
      return;
    }
    let current = this.head;

    while (current) {
      console.log(current.value);
      current = current.next;
    }
  }

  findMiddle() {
    if (!this.head) {
      console.log('No values found!');
      return;
    }
    let slow = this.head;
    let fast = this.head;
    while (fast.next && fast.next.next) {
      slow = slow.next;
      fast = fast.next.next;
    }
    console.log('mid value:', slow.value);
  }

  reverse() {
    if (!this.head) {
      console.log('No values found!');
      return;
    }

    let prev = null;
    let current = this.head;
    let next = null;

    while (current) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    this.head = prev;
  }
}

let list = new LL();

list.append(12);
list.append(23);
list.append(3);
list.prepend(1);
list.append(88);
list.append(23);
list.prepend(123);
list.prepend(34);
list.append(78);

list.print();

list.findMiddle();
