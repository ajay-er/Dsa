class Node {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

class LL {
  constructor() {
    this.head = null;
  }

  append(val) {
    let node = new Node(val);
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

  print() {
    if (!this.head) {
      console.log("no head at all");
      return;
    }
    let current = this.head;
    while (current) {
      console.log(current.val);
      current = current.next;
    }
  }

  prepend(val) {
    let node = new Node(val);
    if (!this.head) {
      this.head = node;
      return;
    } else {
      node.next = this.head;
      this.head = node;
    }
  }

  delete(val) {
    if (!this.head) return;
    if (this.head.val === val) {
      this.head = this.head.next;
      return;
    }

    let current = this.head;
    while (current.next) {
      if (current.next.val === val) {
        current.next = current.next.next;
        return;
      }
      current = current.next;
    }
  }
}

function mergeLL(l1, l2) {
  if (!l1) return l2;
  if (!l2) return l1;

  if (l1.val <= l2.val) {
    l1.next = mergeLL(l1.next, l2);
    return l1;
  } else {
    l2.next = mergeLL(l1, l2.next);
    return l2;
  }
}

function printLinkedList(node) {
  if (!node) {
    console.log("Empty linked list");
    return;
  }
  while (node) {
    console.log(node.val);
    node = node.next;
  }
}

let ll = new LL();
ll.append(5);
ll.append(10);
ll.append(15);

console.log("Initial linked list:");
ll.print(); // Output: 5, 10, 15

ll.prepend(1);
console.log("\nAfter prepending 1:");
ll.print(); // Output: 1, 5, 10, 15

// Delete an element
ll.delete(10);
console.log("\nAfter deleting 10:");
ll.print(); // Output: 1, 5, 15

let ll2 = new LL();
ll2.append(3);
ll2.append(8);
ll2.append(12);

console.log("\nSecond linked list:");
ll2.print(); // Output: 3, 8, 12

let mergedList = mergeLL(ll.head, ll2.head);

console.log("\nMerged linked list:");
printLinkedList(mergedList); // Output: 1, 3, 5, 8, 12, 15
