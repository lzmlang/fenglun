package com.saul.datastructure.zzzsourcecode.ch17;
/*
 * �����൱�ڻ�
 */
public class LinkList {
	//ͷ���
	private Node first;
	
	public LinkList() {
		first = null;
	}
	
	/**
	 * ����һ����㣬��ͷ������в���
	 */
	public void insertFirst(Info info) {
		Node node = new Node(info);
		node.next = first;
		first = node;
	}
	
	/**
	 * ɾ��һ����㣬��ͷ�������ɾ��
	 */
	public Node deleteFirst() {
		Node tmp = first;
		first = tmp.next;
		return tmp;
	}
	
	
	/**
	 * ���ҷ���
	 */
	public Node find(String key) {
		Node current = first;
		while(!key.equals(current.info.getKey())) {
			if(current.next == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}
	
	/**
	 * ɾ������������������������ɾ��
	 */
	public Node delete(String key) {
		Node current = first;
		Node previous = first;
		while(!key.equals(current.info.getKey())) {
			if(current.next == null) {
				return null;
			}
			previous = current;
			current = current.next;
		}
		
		if(current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;
		
	}
}
