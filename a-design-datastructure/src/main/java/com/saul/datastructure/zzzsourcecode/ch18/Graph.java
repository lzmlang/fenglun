package com.saul.datastructure.zzzsourcecode.ch18;
/**
 * ͼ
 * @author Administrator
 *
 */
public class Graph {
	//��������
	private Vertex[] vertexList;
	//�ڽӾ���
	private int[][] adjMat;
	//����������Ŀ
	private int maxSize;
	//��ǰ����
	private int nVertex;
	
	public Graph() {
		vertexList = new Vertex[maxSize];
		adjMat = new int[maxSize][maxSize];
		for(int i = 0; i < maxSize; i++) {
			for(int j = 0; j < maxSize; j++) {
				adjMat[i][j] = 0;
			}
		}
		nVertex = 0;
	}
	
	/**
	 * ��Ӷ���
	 */
	public void addVertex(char label) {
		vertexList[nVertex++] = new Vertex(label);
	}
	
	/**
	 * ��ӱ�
	 */
	public void addEdge(int start,int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
}
