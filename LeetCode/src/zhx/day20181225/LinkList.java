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

    //���������������������
    public void add(int data) {
        //�ж�����Ϊ�յ�ʱ��
        if (head == null) {//���ͷ���Ϊ�գ�˵���������û�д������ǾͰ��µĽ�㸳��ͷ���
            head = new Node(data);
            current = head;
        } else {
            //�����µĽ�㣬���ڵ�ǰ�ڵ�ĺ��棨���µĽ���������й�����
            current.next = new Node(data);
            //������ĵ�ǰ��������ƶ�һλ
            current = current.next;   //�˲��������֮��current���ָ������ӵ��Ǹ����
        }
    }

    //����������������ӡ������������Ĳ�����ʾ�ӽڵ�node��ʼ���б���
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
        //ע���˴���������Ա����Ȩ�޲���Ϊprivate����Ϊprivate��Ȩ���ǽ��Ա�����ʡ�
        public int data; //������
        public Node next;//ָ����

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        //��LinkList���������
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.print(list.head);// ��head�ڵ㿪ʼ�������
    }

}