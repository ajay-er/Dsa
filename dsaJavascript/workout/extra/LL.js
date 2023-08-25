class ListNode {
  constructor(val, next) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

var addTwoNumbers = function (l1, l2) {
  let arrWord1 = [];
  let arrWord2 = [];
  while (l1) {
    arrWord1.push(l1.val);
    l1 = l1.next;
  }

  while (l2) {
    arrWord2.push(l2.val);
    l2 = l2.next;
  }

  let num1 = BigInt(arrWord1.reverse().join(''));
  let num2 = BigInt(arrWord2.reverse().join(''));

  let sum = num1 + num2;
  node =  prepend(sum.toString());
  console.log(node);
};

function prepend(str) {
  let node = new ListNode(+str[0]);
  for (let index = 1; index < str.length; index++) {
    node = new ListNode(+str[index], node);
  }
  return node;
}

function append(arr) {
  let node = new ListNode(arr[0]);
  head = node;
  for (let index = 1; index < arr.length; index++) {
    node.next = new ListNode(arr[index]);
    node = node.next;
  }
  return head;
}

let l1 = [2,4,3]
let l2 = [5,6,4]

l1 = append(l1);
l2 = append(l2);

addTwoNumbers(l2, l1);
