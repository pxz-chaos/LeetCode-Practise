package JianZhiOffer;


import java.util.HashSet;
import java.util.Stack;

/**
 * @ClassName demo02
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/12 16:26
 * @Version 1.0
 */
/*
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
输入：head = [1,3,2]
输出：[2,3,1]
 */
public class demo02 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        singleLinkedList list = new singleLinkedList();
        list.add(node1);
        list.add(node2);
        list.showList();
        int[] arr = {3, 2, 2, 1};
        int num = findRepeatNumber(arr);
        System.out.println(num);

    }

    public static int[] reverse(ListNode head) {
        ListNode temp = head;
        ListNode newHead = null;

        if (head.next == null) {

        }
        ListNode prev = null;
        if (head == null) return null;
        while (temp != null) {
            ListNode next = temp.next;
            prev = temp;
            temp = next;
        }
        newHead = prev;
        return null;
    }

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] num = new int[stack.size()];
        for (int i = 0; i < num.length; i++) {
            num[i] = stack.pop();
        }
        return num;


    }

    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class singleLinkedList {
    //添加节点的方法
    ListNode head = new ListNode(0);

    public void add(ListNode node) {
        //因为head头节点不能动，所以我们需要一个辅助变量temp
        ListNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //2.将最后这个节点的next，指向新的节点即可
        temp.next = node;
    }

    public void showList() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("说明链表为空");
            return;
        }
        //不为空时
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        ListNode temp = head.next;
        while (true) {
            //判断是否为链表的最后
            if (temp == null) {
                break;
            }
            //链表不为空时
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;

        }

    }
}
