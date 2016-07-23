/**
 * 
 */
package com.deadl;

/**
 * @author sleyzerzon
 *
 */
public class DeadlockEx implements Runnable{

	private Object obj1;
    private Object obj2;
 
    public DeadlockEx(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (obj1) {
            System.out.println(name + " acquired lock on Object1: " + obj1);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
 
            synchronized (obj2) {
                System.out.println(name + " acquired lock on Object2: " + obj2);
            }
            System.out.println(name + " released lock on Object2: " + obj2);
        }
        System.out.println(name + " released lock on Object1: " + obj1);
        System.out.println(name + " Finished Crunchify Deadlock Test.");
    }    
}
