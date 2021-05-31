
/**
 * CSC 331 Programming Assignment 2
 * Method 1
 *
 * @author Scott Spurlock
 * @version 9/8/20
 */
public class Method1 {

	/**
	 * This method finds the k largest elements in an integer array
	 * by looping through the array k times, each time picking the largest.
	 * 
	 * @param arr: input array to be searched
	 * @param k: how many elements to select
	 * @return an array of size k holding the largest k elements of A
	 */
	public int[] findTopK(int[] arr, int k) {
		int[] results = new int[k];
		
		for (int i=0; i<k; i++) {
			int top = -1;
			for (int j=0; j<arr.length; j++) {
				if(arr[j] > top) {
					top = arr[j];
					results[i] = arr[j];
					arr[j] = 0;
				}
			}
		}
		
		
		return results;
	}


} // Method1
