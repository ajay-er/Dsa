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
    console.log('------');
    let current = this.head;
    while (current) {
      console.log(current.data);
      current = current.next;
    }
  }
}

let l1 = new LL();

let l2 = new LL();

l1.append(9);
l1.append(6);
l1.append(1);

l2.append(5);
l2.append(3);
l2.append(7);
l1.print();
l2.print();
/* 
var addTwoNumbers = function (l1, l2) {
  let current1 = l1.head;
  let current2 = l2.head;
  let arrWord1 = [];
  let arrWord2 = [];

  while (current1) {
    arrWord1.push(current1.data);

    current1 = current1.next;
  }

  while (current2) {
    arrWord2.push(current2.data);

    current2 = current2.next;
  }

  let num1 = +arrWord1.reverse().join('');
  let num2 = +arrWord2.reverse().join('');

  let sum = num1 + num2;

  let latestLL = sum.toString().split('');
  let node;
  for (const val of latestLL) {
    if (!node) {
      node = new Node(+val);
    } else {
      node = new Node(+val, node);
      console.log(node);
    }
  }
  console.log(node);
};

addTwoNumbers(l1, l2);
 */