import java.util.Arrays;

/**
 * CSC 331 Programming Assignment 2
 * Method 2
 *
 * @author Scott Spurlock
 * @version 9/8/20
 */
public class Method2 {

	/**
	 * This method finds the k largest elements in an integer array
	 * by first sorting the array and then selecting the last K elements.
	 * 
	 * @param arr: input array to be searched
	 * @param k: how many elements to select
	 * @return an array of size k holding the largest k elements of A
	 */
	public int[] findTopK(int[] arr, int k) {
		int[] results = new int[k];
		
		Arrays.sort(arr);
		
		for (int i=0; i<k; i++) {
			if(arr[arr.length-(i+1)] <= 0) {
				return results;
			}
			else {
			results[i] = arr[arr.length-(i+1)];
			}
		}

		
		return results;
	}
} // Method2
