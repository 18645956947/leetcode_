package zhx.day20181225;

import java.awt.print.Printable;

import javax.print.attribute.standard.NumberOfInterveningJobs;

import zhx.day20181225.LinkList;

/** 
* @author lenovo
* @date 2018年12月28日下午9:07:12 
* @Description: Java 实现一个简单的链表
*/
public class LinkList {
    public Node head;
    public Node current;

    //方法：向链表中添加数据
    public void add(int data) {
        //判断链表为空的时候
        if (head == null) {//如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
            head = new Node(data);
            current = head;
        } else {
            //创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
            current.next = new Node(data);
            //把链表的当前索引向后移动一位
            current = current.next;   //此步操作完成之后，current结点指向新添加的那个结点
        }
    }

    //方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
    public void print(Node node) {
        if (node == null) {
            return;
        }

        current = node;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
    }

    class Node {
        //注：此处的两个成员变量权限不能为private，因为private的权限是仅对本类访问。
        public int data; //数据域
        public Node next;//指针域

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        //向LinkList中添加数据
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.print(list.head);// 从head节点开始遍历输出
    }

}