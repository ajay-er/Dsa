function reverse(str) {
  let arr = str.split('');

  arr.reverse();

  return arr.join('');
}

let str = reverse('Ajay');


/* 
function reverse(str){
  return str.split('').reverse().join('')
} */