import java.awt.HeadlessException;
import java.time.LocalDate;

import javax.print.attribute.standard.RequestingUserName;
//建立一个链表 实现增删改查
public class CreatNode {
	//头结点
	public Node head;
	public int size;
	class Node{
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			next = null;
		}
	}
	//向链表尾部插入一个节点
	public void addNode(int num) {
		
		if(head == null) {
			head = new Node(num);
			
		}
		else {
			Node newNode = new Node(num);
			searchLastNode().next = newNode;
		}
		size++;
	}
	
	public Node searchByIndex(int index) {
		if(index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException("链表下标越界");
		}
		Node current = head;
		for(int i = 0;i<size && current != null;i++) {
			if(i == index) {
				return current;
			}
			current = current.next;
		}
		return null;
		
		
	}
	public Node searchLastNode() {
		Node node = head;
		while(node.next != null) {
			node = node.next;
			
		}
		return node;
	}
	
	public void showList() {
		Node current = head;
		while(current != null) {
			System.out.println(current.val);
			current = current.next;
		}
	}
	//删除最后一个元素
	public void delLastNode() {
		delByIndexNode(size-1);
	}
	//删除一个节点
	public void delByIndexNode(int index) {
		if(index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException("链表下标越界");
		}
		Node del = null;
		if(index == 0) {
			del = head;
			head = head.next;
		}
		else {
			Node pre = searchByIndex(index-1);
			del = pre.next;
			pre.next = del.next;
			del.next = null;
		}
		size--;
		
	}
	
	public static void main(String[] args) {
		CreatNode node = new CreatNode();
		for(int i = 1;i<=5;i++) {
			node.addNode(i);
		}
		node.delLastNode();
		node.showList();
	}
	
}
