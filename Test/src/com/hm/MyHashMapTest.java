package com.hm;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Test;

public class MyHashMapTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		
		MyHashMap<Integer, Integer> hashMapCustom = new MyHashMap<Integer, Integer>();
        
		int existingKey = 17;
		int nonexistingKey = 51;
		
		//populate
		hashMapCustom.put(existingKey, 12);
        hashMapCustom.put(25, 121);
        hashMapCustom.put(30, 151);
        hashMapCustom.put(33, 15);
        hashMapCustom.put(35, 89);
        
        assertNotNull("expecting non-null value", hashMapCustom.get(existingKey));
        assertNull("expecting null value", hashMapCustom.get(nonexistingKey));
         
        
        System.out.println("key "+existingKey +" ==> " + hashMapCustom.get(existingKey));
        System.out.println("key "+nonexistingKey +" ==> " + hashMapCustom.get(nonexistingKey));

        System.out.print("Map Content: ");
        hashMapCustom.display();

        boolean resultOfExistingKeyRemoval = hashMapCustom.remove(existingKey);
        boolean resultOfNonExistingKeyRemoval = hashMapCustom.remove(nonexistingKey);
        
        assertTrue("expecting 'true' value",resultOfExistingKeyRemoval);
        assertFalse("expecting 'false' value",resultOfNonExistingKeyRemoval);
        
        
        System.out.println("\n\rremoving existing entry with key "+ existingKey +": " + resultOfExistingKeyRemoval);
        System.out.println("removing non-existing entry with key "+nonexistingKey+": " + resultOfNonExistingKeyRemoval);
        
        assertNull("expecting null value", hashMapCustom.get(existingKey));
        assertNull("expecting null value", hashMapCustom.get(nonexistingKey));
        
        System.out.print("Map Content: ");
        hashMapCustom.display();
	}

}
