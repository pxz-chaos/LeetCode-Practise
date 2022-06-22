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
public class _707_设计链表 {
    private final static int ELEMENT_NOT_FOUND = -1;
    private int size;
    private LinkedList first;

    public int get(int index) {
        return getIndexNode(index).val;
    }

    public void addAtHead(int val) {

        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        checkRangeForAdd(index);
        if (index == 0) {
            first = new LinkedList(val, first);
        } else {
            LinkedList prev = getIndexNode(index - 1);
            prev.next = new LinkedList(val, prev.next);
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        checkRange(index);
        if (index == 0) {
            first = first.next;
        } else {
            LinkedList prev = getIndexNode(index - 1);
            prev.next = prev.next.next;
        }
        size--;
    }

    public int size() {
        return size;
    }


    private LinkedList getIndexNode(int index) {
        //先检查一波索引
        checkRange(index);

        //因为头节点不能动
        LinkedList temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private int checkRange(int index) {
        if (index >= size || index < 0)
            return -1;
        return index;
    }

    private int checkRangeForAdd(int index) {
        if (index > size || index < 0)
            return -1;
        return index;
    }

    private static class LinkedList {
        private int val;
        private LinkedList next;

        public LinkedList(int val, LinkedList next) {
            this.val = val;
            this.next = next;
        }


        @Override
        public String toString() {
            return "LinkedList{" +
                    "val=" + val +
                    '}';
        }
    }

    @Override
    public String toString() {
        LinkedList temp = first;
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
        _707_设计链表 list = new _707_设计链表();

        list.addAtHead(2000);

        list.addAtHead(1000);
        list.addAtHead(2500);
        list.addAtIndex(0, 10);
        list.addAtIndex(1, 20);
        list.addAtIndex(2, 30);
        list.addAtIndex(3, 40);
        list.addAtTail(30);
        System.out.println(list);
        // System.out.println(list.get(1));
        System.out.println("========");
        list.deleteAtIndex(0);
        list.deleteAtIndex(0);
        list.deleteAtIndex(0);
        list.deleteAtIndex(0);
        System.out.println(list);
/*
        list.addAtIndex(1, 20);
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        System.out.println(list);
        System.out.println(list.get(1));*/
    }
}
