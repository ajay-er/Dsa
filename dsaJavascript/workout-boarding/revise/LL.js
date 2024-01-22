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

  print() {
    let current = this.head;
    while (current) {
      console.log(current.data);
      current = current.next;
    }
  }

  delete(data) {
    if (!this.head) return;
    let current = this.head;
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

  findMid() {
    if (!this.head) {
      return;
    }
  
    let first = this.head;
    let second = this.head;
  
    while (second && second.next) {
      first = first.next;
      second = second.next.next;
    }
  
    console.log(first.data);
  }
  
}

let list = new LinkedList();

list.append(12);
list.append(23);
list.append(3);
list.prepend(1);
list.delete(3)


list.print();
list.findMid()
