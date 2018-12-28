package zhx.day20181225;

import java.awt.print.Printable;

import javax.print.attribute.standard.NumberOfInterveningJobs;

import zhx.day20181225.LinkList;

/** 
* @author lenovo
* @date 2018��12��28������9:07:12 
* @Description: Java ʵ��һ���򵥵�����
*/
public class LinkList {
	
	public Node head;
	public Node current;
	//��ӽڵ���ֵ
	public void add(int data) {
		if(head == null) {
			head = new Node(data);
			current = head;
		}
		else {
			current.next = new Node(data);
			current = current.next;
		}
	}
	public void print(Node node) {
		if(node==null) {
			return;
		}
		current = node;
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	class Node{
		public int data;
		public Node next;
		public Node() {
			
		}
		Node(int data) { this.data = data; }
	}
	
	public static void main(String[] args) {
		LinkList list = new LinkList();
		
		for(int i = 0;i<10;i++) {
			list.add(i);
		}
		list.print(list.head);;
	}

}
 