# genuent-test

Pre-screen questions
----------------------------
1.	Explain what 'path to root' means in the context of garbage collection. What are roots?

	If objects in memory are thought of as a tree, we can call the root node of that tree (a starting point) a ‘root’.  To determine what is garbage that can be safely collected, GC can walk from every starting point (locals, globals, statics, etc.), or from every root and recursively follow all its references to make up a list of “live objects”.  Everything else would be garbage, which could be safely collected.

2.	Write code for a simple implementation of HashMap/Hashtable
		
		See code under com.hm package
		
3.	Write a short program to illustrate the concept of deadlock
		
		See code under com.deadl package
		
4.	Explain why recursive implementation of QuickSort will require O(log n) of additional space
		
		See code  under com.qs package
		
5.	Explain the design pattern used in Java and .NET io stream/reader APIs.

		It’s a decorator pattern that is used to extend (decorate) the functionality of an object independent of other instances of the same class.  A new decorator instance  normally wraps the original class’ instance which is being passed to it via constructor and assigned to a field and then every calls to the wrapper delegates to the original instance while being extended with extra necessary behavior.
		The pattern is demonstrated in the following code test as well, see code in the attached zip under com.iter package.

Code Test
--------------

Create an Iterator filtering framework: 

(1) IObjectTest interface with a single boolean test(Object o) method 

(2) An implementation of Iterator (let's call it FilteringIterator) which is initialized with another Iterator and an IObjectTest instance: new FilteringIterator(myIterator, myTest). 

Your FilteringIterator will then allow iteration over 'myIterator', but skipping any objects which don't pass the 'myTest' test. Create a simple unit test for this framework.

