package DataStructs;

import java.util.*;

public class Heap {
	
	private ArrayList<Integer> A;
	private int heapSize;
	
	public Heap() {
		A = new ArrayList<>();
		heapSize = 0;
	}
	
	public Heap(ArrayList<Integer> A) {
		this.A = A;
		heapSize = A.size();
		for (int i = heapSize / 2 - 1; i >= 0; --i) {
			maxHeapify(i);
		}
	}
	
	static int getParent(int i) {
		return (i >> 1) - 1;
	}
	
	static int getLeft(int i) {
		return (i << 1) + 1;
	}
	
	static int getRight(int i) {
		return (i << 1) + 2;
	}
	
	void swap(int idx1, int idx2) {
		Integer aux = A.get(idx1);
		A.set(idx1, A.get(idx2));
		A.set(idx2, aux);
	}
	
	void maxHeapify(int i) {
		int l = getLeft(i);
		int r = getRight(i);
		int largest;
		
		if (l < heapSize && A.get(i) < A.get(l))
			largest = l;
		else
			largest = i;
		
		if (r < heapSize && A.get(largest) < A.get(r))
			largest = r;
		
		if (largest != i) {
			swap(i, largest);
			maxHeapify(largest);
		}
	}
	
	public void buildMaxHeap() {
		heapSize = A.size();
		for (int i = heapSize / 2 - 1; i >= 0; --i) {
			maxHeapify(i);
		}
	}
	
	void heapSort() {
		for (int i = A.size() - 1; i > 0; --i) {
			swap(0, i);
			heapSize--;
			maxHeapify(0);
		}
	}
	
	@Override
	public String toString() {
		return A.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] n = {9, 8, 7, 6, 5, 4, 0, 1, 2, 3};
		ArrayList<Integer> nrs = new ArrayList<Integer>(Arrays.asList(n));
		
		Heap h = new Heap(nrs);
		System.out.println(h);
		h.heapSort();

		System.out.println(h);
		h.buildMaxHeap();
		System.out.println(h);
		h.heapSort();
		System.out.println(h);
	}

}
