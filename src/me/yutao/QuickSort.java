package me.yutao;
import java.util.ArrayList;
import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = new int[] { 72, 6, 57, 88, 60, 42, 83, 73, 48, 85 };
		ArrayList<Integer> r = qsort(a);
		System.out.println(r);
	}

	public static ArrayList<Integer> qsort(int[] a) {
		ArrayList<Integer> r = new ArrayList<Integer>();

		if (a.length == 0) {
			return r;
		}

		if (a.length == 1) {
			r.add(Integer.valueOf(a[0]));
			return r;
		}

		ArrayList<Integer> less = new ArrayList<Integer>();
		ArrayList<Integer> greater = new ArrayList<Integer>();
		int index = new Random().nextInt(a.length);
		for (int i = 0; i < a.length; i++) {
			if (i == index)
				continue;
			if (a[i] <= a[index]) {
				less.add(Integer.valueOf(a[i]));
			} else {
				greater.add(Integer.valueOf(a[i]));
			}
		}

		r.addAll(qsort(list2Array(less)));
		r.add(Integer.valueOf(a[index]));
		r.addAll(qsort(list2Array(greater)));
		return r;
	}

	public static int[] list2Array(ArrayList<Integer> list) {
		int[] r = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			r[i] = list.get(i);
		}
		return r;
	}
}
