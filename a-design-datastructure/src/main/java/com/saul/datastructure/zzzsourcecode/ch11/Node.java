package com.saul.datastructure.zzzsourcecode.ch11;
/*
 * �������ڵ�
 */
public class Node {
	//������
	public long data;
	//������
	public String sData;
	//���ӽڵ�
	public Node leftChild;
	//���ӽڵ�
	public Node rightChild;
	
	/**
	 * ���췽��
	 * @param data
	 */
	public Node(long data,String sData) {
		this.data = data;
		this.sData = sData;
	}
	
}
