package 链表;

/**
 * @ClassName _707_设计链表
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/22 17:10
 * @Version 1.0
 */
/*
设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val?和?next。val?是当前节点的值，next?是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性?prev?以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。

在链表类中实现这些功能：

get(index)：获取链表中第?index?个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为?val?的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为?val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第?index?个节点之前添加值为?val? 的节点。如果?index?等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
deleteAtIndex(index)：如果索引?index 有效，则删除链表中的第?index 个节点。
?

示例：

MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
linkedList.get(1);            //返回2
linkedList.deleteAtIndex(1);  //现在链表是1-> 3
linkedList.get(1);            //返回3
?

提示：

所有val值都在?[1, 1000]?之内。
操作次数将在??[1, 1000]?之内。
请不要使用内置的 LinkedList 库。
通过次数70,868提交次数218,485

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/design-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _707_设计链表2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }


    // size 存储链表中元素的个数
    int size;
    // 虚拟头节点
    ListNode head;

    /**
     * Initialize your data structure here.
     */
    public _707_设计链表2() {
        // 初始化链表
        size = 0;
        head = new ListNode(0);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) return -1;
        ListNode curr = head;
        // 包含了一个虚拟头节点，所以要检查 index + 1 个节点
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        // 如果 index 大于链表的长度，则返回空
        if (index > size) return;
        // 如果 index 为负，则添加到头节点
        if (index < 0) index = 0;

        size++;
        // 设置前置节点进行添加，找到要插入节点的前驱
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }


    @Override
    public String toString() {
        ListNode temp = head.next;
        if (temp.val == 0) return null;
        StringBuilder sb = new StringBuilder();
        sb.append("{size=" + size + ", elements=[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
                sb.append(temp.val);
            } else {
                sb.append(temp.val);
            }
            temp = temp.next;
        }
        sb.append("]}");
        return sb.toString();
    }


    public static void main(String[] args) {
        _707_设计链表2 list = new _707_设计链表2();
        //  list.deleteAtIndex(0);
        list.addAtHead(2000);
        list.addAtHead(1000);
        list.addAtHead(2500);
       /* list.addAtIndex(0, 10);
        list.addAtIndex(1, 20);
        list.addAtIndex(2, 30);
        list.addAtIndex(3, 40);*/
       /* list.addAtTail(30);*/
        System.out.println(list);
        //System.out.println(list);
        System.out.println(list.get(0));
        //System.out.println(list.getNode(3).val);


       /* list.addAtIndex(2, 20);
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        System.out.println(list);
        System.out.println(list.get(1));*/
    }
}
