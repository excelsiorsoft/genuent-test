/**
 * 
 */
package com.qs;

/**
 * Quicksort must store a constant amount [log(n) stack frames] of information for each nested recursive call. </br>
 * Since the best case makes at most O(log n) nested recursive calls, it uses O(log n) space.
 * 
 * @author sleyzerzon
 *
 */
public class QuickSort {
	
/*	public static void exec(int[] array, int start, int end) {
	    if (start < end) {
	        int partition = partition(array, start, end);
	        System.out.println("partition:" +  partition);
	        exec(array, start, partition);
	        exec(array, partition + 1, end);
	    }
	}
	
	public static int partition(int[] array, int left, int right) {
	    int pivotValue = array[(left + right) / 2]; 
	    while (left <= right) {
	        while (array[left] < pivotValue) {
	            left++;
	        }
	        while (array[right] > pivotValue) {
	            right++;
	        }
	        if (left <= right) {
	            
	            int temporary = array[left];
	            array[left] = array[right];
	            array[right] = temporary;

	            left++;
	            right--;
	        }
	    }
	    return left;
	}	*/

	public static void quickSort(int[] array) {
        recursiveQuickSort(array, 0, array.length - 1);
    }

    /**
     * Recursive quicksort logic
     *
     * @param array input array
     * @param startIdx start index of the array
     * @param endIdx end index of the array
     */
    public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) {
     
        int idx = partition(array, startIdx, endIdx);

        // Recursively call quicksort with left part of the partitioned array
        if (startIdx < idx - 1) {
            recursiveQuickSort(array, startIdx, idx - 1);
        }

        // Recursively call quick sort with right part of the partitioned array
        if (endIdx > idx) {
            recursiveQuickSort(array, idx, endIdx);
        }
    }

    /**
     * Divides array from pivot, left side contains elements less than
     * Pivot while right side contains elements greater than pivot.
     *
     * @param array array to partitioned
     * @param left lower bound of the array
     * @param right upper bound of the array
     * @return the partition index
     */
    public static int partition(int[] array, int left, int right) {
        int pivot = array[left]; // taking first element as pivot

        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (array[left] < pivot) {
                left++;
            }
            //searching number which is less than pivot, top down
            while (array[right] > pivot) {
                right--;
            }

            // swap the values
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                //increment left index and decrement right index
                left++;
                right--;
            }
        }
        return left;
    }



	
	
}
