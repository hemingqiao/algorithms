function ListNode(val, next) {
  this.val = (val === undefined ? 0 : val)
  this.next = (next === undefined ? null : next)
}

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
  let dummy = new ListNode(-1);
  dummy.next = head;
  let pre = dummy;
  let cur = dummy.next;

  while (cur && cur.next) {
    let first = cur;
    let second = cur.next;

    first.next = second.next;
    pre.next = second;
    second.next = first;

    pre = first; // 更新pre
    cur = first.next;
  }
  return dummy.next;
};

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
const swapPairsRecu = function (head) {
  if (!head || !head.next) return head;
  let second = head.next;
  let third = second.next; // 因为这里还要读取head.next的next指针，所以要确保head.next非null
  head.next = swapPairsRecu(third);
  second.next = head;
  return second;
}
