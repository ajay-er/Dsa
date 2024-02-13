class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class CircularLL {
  constructor() {
    this.head = null;
  }

  append(data) {
    let newNode = new Node(data);

    if (!this.head) {
      this.head = newNode;
      newNode.next = this.head;
    } else {
      let current = this.head;
      while (current.next !== this.head) {
        current = current.next;
      }
      current.next = newNode;
      newNode.next = this.head;
    }
  }

  prepend(data) {
    let newNode = new Node(data);
    if (!this.head) {
      this.head = newNode;
      newNode.next = this.head;
    } else {
      let current = this.head;
      while (current.next !== this.head) {
        current = current.next;
      }
      newNode.next = this.head;
      current.next = newNode;
      this.head = newNode;
    }
  }

  delete(data) {
    if (!this.head) {
      console.log('List is empty. Unable to delete data.');
      return;
    }

    let current = this.head;
    let prev = null;

    // Find the node to delete and its previous node
    do {
      if (current.value === data) {
        if (prev) {
          prev.next = current.next;
          if (current === this.head) {
            this.head = current.next;
          }
        } else {
          // Deleting the head node
          if (current.next === this.head) {
            this.head = null;
          } else {
            while (current.next !== this.head) {
              current = current.next;
            }
            current.next = this.head.next;
            this.head = this.head.next;
          }
        }
        return;
      }
      prev = current;
      current = current.next;
    } while (current !== this.head);

    console.log(`Value:${data} not in the list`);
  }

  print() {
    if (!this.head) {
      console.log('No values found!');
      return;
    }

    let current = this.head;

    do {
      console.log(current.value);
      current = current.next;
    } while (current !== this.head);
  }
}

const circularLinkedList = new CircularLL();
circularLinkedList.append(1);
circularLinkedList.append(2);

console.log('Circular list:', circularLinkedList);
circularLinkedList.print();
