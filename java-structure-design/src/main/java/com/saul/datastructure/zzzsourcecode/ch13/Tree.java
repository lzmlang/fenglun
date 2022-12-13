package com.saul.datastructure.zzzsourcecode.ch13;
/*
 * ��������
 */
public class Tree {
	//���ڵ�
	public Node root;
	
	/**
	 * ����ڵ�
	 * @param value
	 */
	public void insert(long value,String sValue) {
		//��װ�ڵ�
		Node newNode = new Node(value,sValue);
		//���õ�ǰ�ڵ�
		Node current = root;
		//���ø��ڵ�
		Node parent;
		//���rootΪnull��Ҳ���ǵ�һ�����ʱ��
		if(root == null) {
			root = newNode;
			return;
		} else {
			while(true) {
				//���ڵ�ָ��ǰ�ڵ�
				parent = current;
				//�����ǰָ��Ľڵ����ݱȲ����Ҫ��,��������
				if(current.data > value) {
					current = current.leftChild;
					if(current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * ���ҽڵ�
	 * @param value
	 */
	public Node find(long value) {
		//���õ�ǰ�ڵ㣬�Ӹ��ڵ㿪ʼ
		Node current = root;
		//ѭ����ֻҪ����ֵ�����ڵ�ǰ�ڵ��������
		while(current.data != value) {
			//���бȽϣ��Ƚϲ���ֵ�͵�ǰ�ڵ�Ĵ�С
			if(current.data > value) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			//������Ҳ���
			if(current == null) {
				return null;
			}
		}
		return current;
	}
	
	/**
	 * ɾ���ڵ�
	 * @param value
	 */
	public boolean delete(long value) {
		//���õ�ǰ�ڵ㣬�Ӹ��ڵ㿪ʼ
		Node current = root;
		
		//Ӧ�õ�ǰ�ڵ�ĸ��ڵ�
		Node parent = root;
		//�Ƿ�Ϊ��ڵ�
		boolean isLeftChild = true;
		
		while(current.data != value) {
			parent = current;
			//���бȽϣ��Ƚϲ���ֵ�͵�ǰ�ڵ�Ĵ�С
			if(current.data > value) {
				current = current.leftChild;
				isLeftChild = true;
			} else {
				current = current.rightChild;
				isLeftChild = false;
			}
			//������Ҳ���
			if(current == null) {
				return false;
			}
		}
		
		//ɾ��Ҷ�ӽڵ㣬Ҳ���Ǹýڵ�û���ӽڵ�
		if(current.leftChild == null && current.rightChild == null) {
			if(current == root) {
				root = null;
			} else if(isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if(current.rightChild == null) {
			if(current == root) {
				root = current.leftChild;
			}else if(isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}
		} else if(current.leftChild == null) {
			if(current == root) {
				root = current.rightChild;
			} else if(isLeftChild) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}
		} else {
			Node successor = getSuccessor(current);
			if(current == root) {
				root = successor;
			} else if(isLeftChild) {
				parent.leftChild = successor;
			} else{
				parent.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
		}
		
		return true;
		
		
	}
	
	public Node getSuccessor(Node delNode) {
		Node successor = delNode;
		Node successorParent = delNode;
		Node current = delNode.rightChild;
		
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		if(successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
	
	/**
	 * ǰ�����
	 */
	public void frontOrder(Node localNode) {
		if(localNode != null) {
			//���ʸ��ڵ�
			System.out.println(localNode.data + ", " + localNode.sData);
			//ǰ�����������
			frontOrder(localNode.leftChild);
			//ǰ�����������
			frontOrder(localNode.rightChild);
		}
	}
	
	/**
	 * �������
	 */
	public void inOrder(Node localNode) {
		if(localNode != null) {
			//�������������
			inOrder(localNode.leftChild);
			//���ʸ��ڵ�
			System.out.println(localNode.data + ", " + localNode.sData);
			//��Ѯ����������
			inOrder(localNode.rightChild);
		}
	}
	
	/**
	 * �������
	 */
	public void afterOrder(Node localNode) {
		if(localNode != null) {
			//�������������
			afterOrder(localNode.leftChild);
			//�������������
			afterOrder(localNode.rightChild);
			//���ʸ��ڵ�
			System.out.println(localNode.data + ", " + localNode.sData);
		}
	}
}
