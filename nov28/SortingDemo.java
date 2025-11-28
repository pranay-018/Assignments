package com.nov_28.nov_28;

import java.util.Vector;

class MergeSortAlgo {
	private int[] array;

	public MergeSortAlgo() {
	}

	public MergeSortAlgo(int[] arr) {
//		array = new int[arr.length];
//		for (int i = 0; i < arr.length; i++) {
//			array[i] = arr[i];
//		}
		array = arr;
		this.mergeSort(0, array.length - 1);
	}

	public void mergeSort(int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		this.mergeSort(low, mid);
		this.mergeSort(mid + 1, high);
		this.merge(low, mid, high);
		return;
	}

	public void merge(int low, int mid, int high) {
		Vector<Integer> vec = new Vector<Integer>();
		int left = low;
		int right = mid + 1;
		while (left <= mid && right <= high) {
			if (array[left] <= array[right]) {
				vec.add(array[left]);
				left++;
			} else {
				vec.add(array[right]);
				right++;
			}
		}
		while (left <= mid) {
			vec.add(array[left]);
			left++;
		}
		while (right <= high) {
			vec.add(array[right]);
			right++;
		}
		for (int i = low; i <= high; i++) {
			array[i] = vec.get(i - low);
		}
	}

	public void display() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}

class QuickSortAlgo{
	private int[] array;

	public QuickSortAlgo() {
	}

	public QuickSortAlgo(int[] arr) {
		array = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			array[i] = arr[i];
		}
		this.quickSort(0, array.length - 1);
	}
	public void quickSort(int low,int high) {
		if(low>=high) return ;
		int p = this.partition(low,high);
		this.quickSort(low, p-1);
		this.quickSort(p+1, high);
		
		
	}

	public int partition(int low, int high) {
		int pivot = array[low];
		int i = low;
		int j = high;
		while(i<j) {
			while(pivot >= array[i] && i<high) {
				i++;
			}
			while(pivot<array[j] && j>low) {
				j--;
			}
			if(i<j) {
				int t = array[i];
				array[i] = array[j];
				array[j] = t;
			}
		}
		int t = array[j];
		array[j] = array[low];
		array[low] = t;
		return j;
	}
	public void display() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}

public class SortingDemo {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 1, 2, 8, 3, 2, 5, 9, 0 ,1,8};
		MergeSortAlgo mergedArray = new MergeSortAlgo(arr);
		mergedArray.display();
		int[] arr2 = { 3, 4, 5, 1, 2, 8, 3, 2, 5, 9, 0 ,1,8};
		QuickSortAlgo quickSortArray = new QuickSortAlgo(arr2);
		quickSortArray.display();
		

	}

}
