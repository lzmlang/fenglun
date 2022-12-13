package com.saul.datastructure.zzzsourcecode.ch08;
/*
 * ϣ������
 */
public class ShellSort {
	/**
	 * ���򷽷�
	 */
	public static void sort(long[] arr) {
		//��ʼ��һ�����
		int h = 1;
		//���������
		while(h < arr.length / 3) {
			h = h * 3 + 1;
		}
		
		while(h > 0) {
			//���в�������
			long tmp = 0;
			for(int i = h; i < arr.length; i++) {
				tmp = arr[i];
				int j = i;
				while(j > h - 1 && arr[j - h] >= tmp) {
					arr[j] = arr[j - h];
					j -= h;
				}
				arr[j] = tmp;
			}
			//��С���
			h = (h - 1) / 3;
		}
	}
}
