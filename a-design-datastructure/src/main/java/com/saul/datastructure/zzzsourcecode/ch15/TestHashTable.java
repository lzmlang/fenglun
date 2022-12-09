package com.saul.datastructure.zzzsourcecode.ch15;

public class TestHashTable {
	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.insert(new Info("a","����"));
		ht.insert(new Info("ct","����"));
		ht.insert(new Info("wangwu","����"));
		
		System.out.println(ht.find("a").getName());
		System.out.println(ht.find("ct").getName());
	}
}
