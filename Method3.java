import java.util.Arrays;
import java.util.Random;

/**
 * CSC 331 Programming Assignment 2
 * Method 3
 *
 * @author Scott Spurlock
 * @version 9/8/20
 */
public class Method3 {
	// For finding a random pivot in the partition method.
	private Random randGen = new Random();

	/**
	 * This method finds the k largest elements in an integer array
	 * by calling the selection method to find the location of the
	 * (n-k)th element, copying the k largest elements into an array,
	 * (i.e., the elements to the right of the pivot)
	 * and then calling insertion sort on this array to put them in order
	 * from largest to smallest.
	 * 
	 * @param arr: input array to be searched
	 * @param k: how many elements to select
	 * @return an array of size k holding the largest k elements of A
	 */
	public int[] findTopK(int[] arr, int k) {
		int[] results = new int[k];
		
		selection(arr, arr[0], arr[arr.length-1], k);
		int pivIdx = arr.length-1-k;
		//System.out.println("pivIdx : " + pivIdx);
		
		for (int i=0; i<k; i++) {
			results[i] = arr[pivIdx+1];
		}
		
		insertionSortReverse(results);
		
		return results;
	}

	/**
	 * Return kth smallest element of array A between left..right
	 * @param A: input array of ints
	 * @param left: index of the left-most element to be considered
	 * @param right: index of the right-most element to be considered
	 * @param k: the order of the element to find
	 * @return the value of the kth smallest element in A between left and right
	 */
	public int selection(int[] A, int left, int right, int k) {
		
		if (left == right) { // Base case
			// System.out.println("reached");
			return A[left];
		}
		
		int pivotIndex = partition(A, left, right);
		
		if (k == pivotIndex) {
			// System.out.println("reached2");
			return A[k];
		}
		else if (k < pivotIndex) {
			// System.out.println("reached3");
			return selection(A, left, pivotIndex-1, k);
		}
		else {
			// System.out.println("reached4");
			return selection(A, pivotIndex+1, right, k);
		}
		
	}
	
	/**
	 * Partition the elements of an array A between left and right
	 * so that, for some pivot element, all the elements to its left
	 * are less and all the elements to its right are greater.
	 * Recommendation: pick the index of the pivot element randomly.
	 * 
	 * @param A: input array of ints
	 * @param left: index of the left-most element to be considered
	 * @param right: index of the right-most element to be considered
	 * @return final index of the pivot element
	 */
	public int partition(int[] A, int left, int right) {
		
		int random = (int)randGen.nextInt(right-left+1)+left;
		swap(A,random,right);
		double pivot = A[right];
		
		int i = left;
		int j = right;
		
		while (i < j) {
			while (A[i] < pivot && i < right) 
				i++;
			
			while (A[j] >= pivot && j > left) 
				j--;
			
			if (i < j) 
				swap(A,i,j);
		}
		
		swap (A,i,right);
	    return i;
	}

	/**
	 * Helper method to swap two elements in an array.
	 * @param A: array
	 * @param a: first index
	 * @param b: second index
	 */
	public  void swap(int[] A, int a, int b) {
		// TBD - should be 3 lines
		int tmp = A[a];
	    A[a] = A[b];
	    A[b] = tmp;
	}	

	/**
	 * Sort the elements in the array A using insertion sort.
	 * Elements will be sorted in reverse order, so that the
	 * largest is first and the smallest is last.
	 * @param A: input array of ints.
	 */
	public void insertionSortReverse(int[] A) {
		int n = A.length;
		for (int j = 1; j < n; j++) {
			int key = A[j];
			int i = j - 1;
			while (i >= 0 && A[i] < key) {
				A[i+1] = A[i];
				i--;
			}
			A[i+1] = key;
		}
	}
	
} // Method3
