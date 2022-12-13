package com.saul.datastructure.zzzsourcecode.ch16;

import java.math.BigInteger;

public class HashTable {
	private Info[] arr;
	
	/**
	 * Ĭ�ϵĹ��췽��
	 */
	public HashTable() {
		arr = new Info[100];
	}
	
	/**
	 * ָ�������ʼ����С
	 */
	public HashTable(int maxSize) {
		arr = new Info[maxSize];
	}
	
	/**
	 * ��������
	 */
	public void insert(Info info) {
		//��ùؼ���
		String key = info.getKey();
		//�ؼ������Զ��Ĺ�ϣ��
		int hashVal = hashCode(key);
		//�����������Ѿ���ռ�ã�����������һ��δ��ɾ��������
		while(arr[hashVal] != null && arr[hashVal].getName() != null) {
			//���еݼ�
			++hashVal;
			//ѭ��
			hashVal %= arr.length;
		}
		arr[hashVal] = info;
	}
	
	/**
	 * ��������
	 */
	public Info find(String key) {
		int hashVal = hashCode(key);
		while(arr[hashVal] != null) {
			if(arr[hashVal].getKey().equals(key)) {
				return arr[hashVal];
			}
			++hashVal;
			hashVal %= arr.length;
		}
		return null;
	}
	
	/**
	 * ɾ������
	 * @param key
	 * @return
	 */
	public Info delete(String key) {
		int hashVal = hashCode(key);
		while(arr[hashVal] != null) {
			if(arr[hashVal].getKey().equals(key)) {
				Info tmp = arr[hashVal];
				tmp.setName(null);
				return tmp;
			}
			++hashVal;
			hashVal %= arr.length;
		}
		return null;
	}
	
	public int hashCode(String key) {
//		int hashVal = 0;
//		for(int i = key.length() - 1; i >= 0; i--) {
//			int letter = key.charAt(i) - 96;
//			hashVal += letter;
//		}
//		return hashVal;
		
		BigInteger hashVal = new BigInteger("0");
		BigInteger pow27 = new BigInteger("1");
		for(int i = key.length() - 1; i >= 0; i--) {
			int letter = key.charAt(i) - 96;
			BigInteger letterB = new BigInteger(String.valueOf(letter));
			hashVal = hashVal.add(letterB.multiply(pow27));
			pow27 = pow27.multiply(new BigInteger(String.valueOf(27)));
		}
		return hashVal.mod(new BigInteger(String.valueOf(arr.length))).intValue();
	}
}
