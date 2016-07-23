/**
 * 
 */
package com.hm;

/**
 * @author sleyzerzon
 *
 */
public class MyHashMap<K, V> {

	private Entry<K, V>[] table; // array of entries
	private int capacity = 32; // initial capacity

	static class Entry<K, V> {
		private K key;
		private V value;
		private Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	@SuppressWarnings("unchecked")
	public MyHashMap() {
		table = new Entry[capacity];
	}

	/**
	 * Implements storing an entry in the hashmap. </br>
	 * 
	 * Replaces existing mapping for a key</br>
	 * 
	 * <code>Null</code> keys are disallowed, <code>null</code> values are fine
	 * 
	 * @param newKey
	 * @param data
	 */
	public void put(K newKey, V data) {

		if (newKey == null)
			return; // no nulls allowed

		// grab the hash of the key.
		int hash = hash(newKey);

		// create a new entry.
		Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);

		if (table[hash] == null) { // store an entry if we don't have it yet

			table[hash] = newEntry;

		} else { // we already had such entry

			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];

			while (current != null) { // last entry of a bucket.

				if (current.key.equals(newKey)) {

					if (previous == null) {

						newEntry.next = current.next;
						table[hash] = newEntry;
						return;

					} else {
						newEntry.next = current.next;
						previous.next = newEntry;
						return;
					}
				}

				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}

	/**
	 * Given a key finds its corresponding value
	 * 
	 * @param key
	 */
	public V get(K key) {

		int hash = hash(key);

		if (table[hash] == null) {

			return null;

		} else {

			Entry<K, V> temp = table[hash];

			while (temp != null) {
				if (temp.key.equals(key)) {
					return temp.value;
				}
				temp = temp.next;
			}
			return null; // key is not found.
		}
	}

	/**
	 * Remove functionality
	 * 
	 * @param key
	 */
	public boolean remove(K deleteKey) {

		int hash = hash(deleteKey);

		if (table[hash] == null) {

			return false;
		} else {

			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];

			while (current != null) { // last entry node of the bucket.

				if (current.key.equals(deleteKey)) {

					if (previous == null) { // delete first entry node.
						table[hash] = table[hash].next;
						return true;
					} else {
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
			return false;
		}

	}

	/**
	 * Basic custom hashing mechanism implementation - helps in finding the
	 * appropriate bucket location to store the data. N.B. Affects performance
	 * 
	 * @param key
	 */
	private int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	/**
	 * Displays all key-value pairs present without guaranteeing the insertion
	 * order
	 * 
	 * @param key
	 */
	public void display() {

		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				Entry<K, V> entry = table[i];
				while (entry != null) {
					System.out.print("{" + entry.key + "=" + entry.value + "}"
							+ " ");
					entry = entry.next;
				}
			}
		}

	}

	

}



