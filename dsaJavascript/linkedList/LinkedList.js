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
    const node = new Node(data);

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
    const node = new Node(data);

    node.next = this.head;

    this.head = node;
  }

  delete(data) {
    if (!this.head) {
      throw new Error('Oops! head Evdra?🥴!');
    }

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
          current.next = null;
        }

        return;
      }

      current = current.next;
    }

    throw new Error('Nokkim kandum Value adikada!...');
  }

  print() {
    let current = this.head;

    let str = '';
    while (current) {
      str = str + '--->' + current.data;
      current = current.next;
    }

    console.log(str);
  }
}

let list = new LinkedList();

list.append(12);
list.append(23);
list.append(3);
list.prepend(1);
list.delete(2);

list.print();
