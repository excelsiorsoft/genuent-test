package com.qs;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void test() {
		int[] array = {4, 77, 98, 30, 20, 50, 77, 22, 49, 2};
		QuickSort.quickSort(array);
		for (int i = 0; i < array.length; i++) {
		    System.out.print(array[i] + " ");
		}
	}

}
