
// 链表定义
// let list = {val: 1, next: {val: 2, next: {val: 3, next: null}}};
let list = {val: 1, next: null};

function reverseList(head) {
  if (head == null || head.next == null) return head;
  let rest = head.next;
  head.next = null; // 断开头部和rest之间的连接
  let reversed = reverseList(rest);
  rest.next = head; // 把rest翻转后，rest就成了链表reversed的尾部，把之前拿出的头拼到新链表reversed的尾部就完成了整个链表的翻转
  return reversed;
}

console.log(reverseList(list)); // { val: 3, next: { val: 2, next: { val: 1, next: null } } }
