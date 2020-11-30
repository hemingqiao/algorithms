package blogandquestion.algorithms.linkedlist.mylinkedlist707;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/30 18:40:04
 * description:
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *  
 *
 * 示例：
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *  
 *
 * 提示：
 *
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 *
 * 实现的是双向链表
 */
public class MyLinkedList {
    private Node first; // 头结点
    private Node last; // 尾结点
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        first = last = null;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return getNode(index).val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node f = first;
        Node newNode = new Node(null, val, first);
        first = newNode;
        /*如果f为null，意味着是一个空集，在执行完添加后，应将last也指向集合中唯一的元素*/
        if (f == null) {
            last = newNode;
        } else {
            // 否则，集合非空，进行两个元素的连接
            f.prev = first;
        }
        size++; // 更新size
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node l = last;
        Node newNode = new Node(last, val, null);
        last = newNode;
        /*同理，这里也是对添加之前集合是否为空的判断，如果l为null，说明添加前为空集，添加后需要把first指向当前集合中的唯一元素*/
        if (l == null) {
            first = newNode;
        } else {
            l.next = last;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            // do nothing
            return;
        } else if (index <= 0) {
            addAtHead(val);
            return; // 注意不要忘了这里的return
        } else if (index == size) {
            addAtTail(val);
            return; // 注意不要忘了这里的return
        } else {
            Node succ = getNode(index);
            Node pred = succ.prev;
            Node newNode = new Node(pred, val, succ);
            succ.prev = newNode;
            pred.next = newNode;
        }
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node removedNode = getNode(index);
        Node pred = removedNode.prev;
        Node next = removedNode.next;

        if (pred == null) {
            /*如果pred为null，说明待删除的结点是头结点，所以将first后移*/
            first = next;
        } else {
            pred.next = next;
            removedNode.prev = null;
        }

        if (next == null) {
            /*同理，如果next为null，说明待删除结点是尾结点，需要将尾结点前移*/
            last = pred;
        } else {
            next.prev = pred;
            removedNode.next = null;
        }
        size--;
    }

    private Node getNode(int index) {
        int mid = size >> 1;
        if (index < mid) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            Node temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
            return temp;
        }
    }

    private static class Node {
        int val;
        Node prev;
        Node next;

        Node(Node prev, int item, Node next) {
            this.prev = prev;
            this.val = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList ml = new MyLinkedList();
        ml.addAtHead(7);
        ml.addAtHead(2);
        ml.addAtHead(1);
        ml.addAtIndex(3, 0);
        ml.deleteAtIndex(2);
        ml.addAtHead(6);
        ml.addAtTail(4);
        int res = ml.get(4);
        System.out.println(res);
    }
}
