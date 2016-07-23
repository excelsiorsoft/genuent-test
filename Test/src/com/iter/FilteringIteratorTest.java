package com.iter;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class FilteringIteratorTest {

	private static List<Integer> list;
	private static Iterator<Integer> iter;;
	private static Iterator<Integer> cut;

	@BeforeClass
	public static void init() {

		list = new ArrayList<Integer>();

		for (int i = 1; i < 10; i++) {
			list.add(i);
		}

	}

	@Test
	public void filterEven() {

		System.out.println(list);

		IObjectTest myTest = new IObjectTest() {

			@Override
			public boolean test(Object o) {
				boolean result = false;
				if (o instanceof Integer) {
					result = ((Integer) o).intValue() % 2 == 0;
				}
				return result;
			}
		};

		cut = new FilteringIterator<Integer>(list.iterator(), myTest);

		List res = new ArrayList();

		for (; cut.hasNext();) {
			res.add(cut.next());
		}
		assertTrue("wrong size", res.size() == 4);

		System.out.println(res);

	}

	@Test
	public void filterOdd() {

		System.out.println(list);

		IObjectTest myTest = new IObjectTest() {

			@Override
			public boolean test(Object o) {
				boolean result = false;
				if (o instanceof Integer) {
					result = ((Integer) o).intValue() % 2 != 0;
				}
				return result;
			}
		};

		cut = new FilteringIterator<Integer>(list.iterator(), myTest);

		List res = new ArrayList();

		for (; cut.hasNext();) {
			res.add(cut.next());
		}
		assertTrue("wrong size", res.size() == 5);

		System.out.println(res);

	}

}
