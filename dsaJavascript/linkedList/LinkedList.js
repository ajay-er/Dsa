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

function mergeLinkedLists(list1, list2) {
  if (!list1.head) {
    return list2;
  }

  if (!list2.head) {
    return list1;
  }

  const mergedList = new LinkedList();

  let current1 = list1.head;
  let current2 = list2.head;

  while (current1 || current2) {
    if (current1 && current2) {
      if (current1.data <= current2.data) {
        mergedList.append(current1.data);
        current1 = current1.next;
      } else {
        mergedList.append(current2.data);
        current2 = current2.next;
      }
    } else if (current1) {
      mergedList.append(current1.data);
      current1 = current1.next;
    } else {
      mergedList.append(current2.data);
      current2 = current2.next;
    }
  }

  return mergedList;
}

let l1 = new LinkedList();
let l2 = new LinkedList();

l2.append(39);
l2.append(13);
l2.append(83);
l2.prepend(8);

l1.append(12);
l1.append(23);
l1.append(3);
l1.prepend(1);

const merge = mergeLinkedLists(l1, l2);
merge.print()